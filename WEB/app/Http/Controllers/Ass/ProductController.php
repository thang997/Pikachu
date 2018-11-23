<?php

namespace App\Http\Controllers\Ass;

use DB;
use App\Product;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;

class ProductController extends Controller
{
  public function index()
  {
    //$products = Product::orderBy('id', 'desc')->get();
    $products = DB::table('Product')->paginate(3);

    return view('list', [
        'data' => $products
    ]);
  }

  public function add($id=null)
  {
    $data = null;
    if(isset($id)) {
      $data = Product::findOrFail($id);
    }
    return view('edit', ['data'=>$data]);
  }

  public function get($id)
  {
    $data = Product::findOrFail($id);
    return view('detail',['data'=> $data, 'message' => 'OK' ]);
  }

  public function getjson($id)
  {
    $data = Product::findOrFail($id);
    return response()->json(['data' => $data]);
  }

  public function save(Request $request)
  {
    $this->validate($request, [
        'name' => 'required|max:255',
        'price' => 'required|integer',
        'email' => 'required|email|max:50',
        'order_id' => 'required|integer',
    ]);

    $product = new Product;
    $product->name = $request->name;
    $product->price = $request->price;
    $product->email = $request->email;
    $product->order_id = $request->order_id;
    $product->save();
    return redirect('/product/list');
  }

  public function delete(Request $request, $id)
  {
    Product::findOrFail($id)->delete();
    return redirect('/product/list');
  }
}
