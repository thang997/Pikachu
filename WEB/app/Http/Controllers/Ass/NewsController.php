<?php

namespace App\Http\Controllers\Ass;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use DB;
use App\Tintuc;

class NewsController extends Controller
{
   public function index6()
  {
    //$products = Product::orderBy('id', 'desc')->get();
    $news = DB::table('news')
    ->orderBy('updated_at','desc')
    ->get();

    return view('news', ['data' => $news]);
  }

 public function add($id=null)
  {
    $data = null;
    if(isset($id)) {
      $data = Tintuc::findOrFail($id);
    }
    return view('editnews', ['data'=>$data]);
  }
    
  public function save(Request $request)
  {
    $nguoidung = new Tintuc;
    $nguoidung->tittle = $request->tittle;
    $nguoidung = $request->file('images');
    $nguoidung->getClientOriginalName();
    $nguoidung->content = $request->content;
    $nguoidung->save();
    return redirect('/news');
  }


  public function update(Request $request, $id)
{
      $nguoidung = Tintuc::find($id);
      $nguoidung->tittle = $request->get('tittle');
      $nguoidung->images = $request->get('images');
      $nguoidung->content = $request->get('content');
      $nguoidung->save();

      return redirect('/news');
   } 

  public function delete(Request $request, $id)
  {
    Tintuc::findOrFail($id)->delete();
    return redirect('/news');
  }

 public function search(Request $request)
{
  $title=$request->get('title');

          
    $results = DB::table('news')->where('tittle', 'LIKE', '%'. $title .'%')
    ->paginate(40);

    return view('news')->with('data', $results);                 

     }
}




