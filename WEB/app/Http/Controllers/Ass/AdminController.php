<?php

namespace App\Http\Controllers\Ass;

use DB;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Sanpham;

class AdminController extends Controller
{
   public function index()
  {
    //$products = Product::orderBy('id', 'desc')->get();
    $sanphams = DB::table('sanpham')->paginate(8);

    return view('listsp', ['data' => $sanphams]);
  }

  public function add($id=null)
  {
    $data = null;
    if(isset($id)) {
      $data = Sanpham::findOrFail($id);
    }
    return view('edit2', ['data'=>$data]);
  }
    public function get($id)
  {
    $data = Sanpham::findOrFail($id);
    return view('detail',['data'=> $data, 'message' => 'OK' ]);
  }
  public function save(Request $request)
  {
    // $this->validate($request, [
    //     'Name' => 'required|max:255',
    //     'Picture' => 'required',
    //     'Price' => 'required|integer',
    //     'Order' => 'required|integer',
    // ]);

    $sanpham = new Sanpham;
    $sanpham->name = $request->name;
    $file = $request->file('input_img');
            $name = $file->getClientOriginalExtension();
            $request->file('input_img')->move("/picture", $name);
    $sanpham->price = $request->price;
    $sanpham->order = $request->order;
    $sanpham->save();
    return redirect('/listsp');
  }

  public function update(Request $request, $id)
  { 
      $sanpham = Sanpham::find($id);
      $sanpham->name = $request->get('name');
      $sanpham->picture = $request->get('picture');
      $sanpham->price = $request->get('price');
      $sanpham->order = $request->get('order');

      $sanpham->save();

      return redirect('/listsp');
   } 

  public function delete(Request $request, $id)
  {
    Sanpham::findOrFail($id)->delete();
    return redirect('/listsp');
  }
}
