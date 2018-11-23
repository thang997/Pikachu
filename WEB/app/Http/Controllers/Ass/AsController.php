<?php

namespace App\Http\Controllers\Ass;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use DB;
use App\Pikachu;
use Illuminate\Support\Collection;
use App\User;
use App\Http\Requests;
use Mail;
use Session;

class AsController extends Controller
{
  public function index4()
  {
    $sanphams = DB::table('users')
    ->orderBy('score','desc')
    ->take(5)
    ->get();
    return view('pikachu', ['data' => $sanphams]);

    $news = DB::table('news')
    ->orderBy('updated_at','desc')
    ->get();
    return view('pikachu', ['data' => $news]);
  } 
  public function index5()
  {
    //$products = Product::orderBy('id', 'desc')->get();
    $users = DB::table('users')->paginate(8);

    return view('userpikachu', ['data' => $users]);
  }

  public function add($id=null)
  {
    $data = null;
    if(isset($id)) {
      $data = User::findOrFail($id);
    }
    return view('editpikachu', ['data'=>$data]);
  }
  
  public function save(Request $request)
  {
    $nguoidung = new User;
    $nguoidung->name = $request->name;
    $nguoidung->email = $request->email;
    $nguoidung = $request->file('avatar');
    $nguoidung->getClientOriginalName();
    $nguoidung->move('public/images/pikachu');
    $nguoidung->score = $request->score;
    $nguoidung->save();
    return redirect('/userpikachu');
  }


  public function update(Request $request, $id)
  {
    $nguoidung = User::find($id);
    $nguoidung->name = $request->get('name');
    $nguoidung->email = $request->get('email');
    $nguoidung->avatar = $request->get('avatar');
    $nguoidung->score = $request->get('score');
    $nguoidung->save();

    return redirect('/userpikachu');
  } 

  public function delete(Request $request, $id)
  {
    User::findOrFail($id)->delete();
    return redirect('/userpikachu');
  }
  // public function search(Request $request)
  // {
  //   $title=$request->get('search');


  //   $results = DB::table('users')->where('name', 'LIKE', '%'. $title .'%')
  //   ->orWhere('email', 'LIKE', '%'. $title .'%')
  //   ->paginate(40);

  //   return view('userpikachu')->with('data', $results);                 

  // }


  public function postContact(Request $request) {
    
    $data = array(
      'name' => $request->name,
      'email' => $request->email,
      'subject' => $request->subject,
      'bodyMessage' => $request->message,
    );

    Mail::send('emails.contact', $data, function($message) use ($data){
      $message->from($data['email']);
      $message->to('siro18294@gmail.com');
      $message->subject($data['subject']);
    });

    Session::flash('success', 'Your Email was Sent!');
    return redirect('/');

  }

  public function lock($id)
  {
    $data = User::find($id);
    $data->lock = 1;
    $data->save();
    return redirect('/userpikachu');
  }

  public function unlock($id)
  {
    $data = User::find($id);
    $data->lock = 0;
    $data->save();
    return redirect('/userpikachu');
  }

  public function postSearch()
  {
    $email = Input::get('email');
    $name = Input::get('name');
    $score = Input::get('score');
      //echo '</br>'.$email;
      //echo '</br>'.$name;
      //echo '</br>'.$score;
    if($score == "0")
    {
        //$data = User::where('score', 'between', ['2000', '6000'])->get(); test thu ma deo dung
      $data = DB::table('users')->where('email',$email)->orWhere('name', $name)->get();
    }
    elseif($score == "1")
    {
      $data = DB::table('users')->whereBetween('score', [0, 2000])->orWhere('email',$email)->orWhere('name', $name)->get();
      
    }
    elseif ($score == "2")
    {
      $data = DB::table('users')->whereBetween('score', [2000, 4000])->orWhere('email',$email)->orWhere('name', $name)->get();
    }
    elseif ($score == "3")
    {
      $data = DB::table('users')->whereBetween('score', [4000, 6000])->orWhere('email',$email)->orWhere('name', $name)->get();
    }
    else 
    {
      $data = DB::table('users')->where('score', '>', 6000)->orWhere('email',$email)->orWhere('name', $name)->get();
    }

    return view('search',compact('data'));
  }

  public function getSearch()
  {
    return view('search');
  }
}



