<?php

namespace App\Http\Controllers\Ass;

use DB;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Nguoidung;

class MemberController extends Controller
{
   public function index()
  {
    //$products = Product::orderBy('id', 'desc')->get();
    $nguoidungs = DB::table('nguoidung')->paginate(8);

    return view('user', ['data' => $nguoidungs]);
  }
  
  public function add($id=null)
  {
    $data = null;
    if(isset($id)) {
      $data = Nguoidung::findOrFail($id);
    }
    return view('edit3', ['data'=>$data]);
  }
    
  public function save(Request $request)
  {
    // $this->validate($request, [
    //     'Name' => 'required|max:255',
    //     'Age' => 'required',
    //     'Phone' => 'required',
    //     'Email' => 'required',
    //     'Address' => 'required|string',
    // ]);

    $nguoidung = new Nguoidung;
    $nguoidung->name = $request->name;
    $nguoidung->age = $request->age;
    $nguoidung->phone = $request->phone;
    $nguoidung->email = $request->email;
    $nguoidung->address = $request->address;
    $nguoidung->save();
    return redirect('/user');
  }


  public function update(Request $request, $id)
{
      $nguoidung = Nguoidung::find($id);
      $nguoidung->name = $request->get('name');
      $nguoidung->age = $request->get('age');
      $nguoidung->phone = $request->get('phone');
      $nguoidung->email = $request->get('email');
      $nguoidung->address = $request->get('address');
      $nguoidung->save();

      return redirect('/user');
   } 

  public function delete(Request $request, $id)
  {
    Nguoidung::findOrFail($id)->delete();
    return redirect('/user');
  }
}
