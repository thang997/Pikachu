<?php

namespace App\Http\Controllers\Ass;

use DB;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Library;

class LibraryController extends Controller
{
     public function index()
  {
  	$books = DB::table('library')->paginate(40);
    return view('library', ['data' => $books]);

  } 
  public function add($bookid=null)
  {
    $data = null;
    if(isset($bookid)) {
      $data = Library::findOrFail($bookid);
    }
    return view('add1', ['data'=>$data]);
  }
    
  public function save(Request $request)
  {

    $books = new Library;
    $books->bookid = $request->bookid;
    $books->authorid = $request->authorid;
    $books->title = $request->title;
    $books->ISBN = $request->ISBN;
    $books->pub_year = $request->pub_year;
    $books->avaiable = $request->avaiable;
    $books->save();
    return redirect('/library');
  }


  public function update(Request $request, $bookid)
{
      $books = Library::find($bookid);
      $books->bookid = $request->get('bookid');
      $books->authorid = $request->get('authorid');
      $books->title = $request->get('title');
      $books->ISBN = $request->get('ISBN');
      $books->pub_year = $request->get('pub_year');
      $books->avaiable = $request->get('avaiable');
      $books->save();

      return redirect('/library');
   } 

  public function delete(Request $request, $bookid)
  {
    Library::findOrFail($bookid)->delete();
    return redirect('/library');
  }

 public function search(Request $request)
{
	$title=$request->get('title');

          
    $results = DB::table('library')->where('title', 'LIKE', '%'. $title .'%')
    ->orWhere('ISBN', 'LIKE', '%'. $title .'%')
    ->paginate(40);

    return view('library')->with('data', $results);                 

     }
 
}
