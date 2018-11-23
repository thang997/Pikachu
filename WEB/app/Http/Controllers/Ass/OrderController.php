<?php

namespace App\Http\Controllers\Ass;

use DB;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use App\Order;

class OrderController extends Controller
{
   public function index()
  {
    //$products = Product::orderBy('id', 'desc')->get();
    $orders = DB::table('order')->paginate(8);

    return view('order', ['data' => $orders]);
  }
  public function add($id=null)
  {
    $data = null;
    if(isset($id)) {
      $data = Order::findOrFail($id);
    }
    return view('edit4', ['data'=>$data]);
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

    $order = new Order;
    $order->CustomerId = $request->CustomerId;
    $order->DetailId = $request->DetailId;
    $order->ProductId = $request->ProductId;
    $order->Price = $request->Price;
    $order->CreatedDate = $request->CreatedDate;
    $order->Status = $request->Status;
    $order->save();
    return redirect('/order');
  }


  public function update(Request $request, $id)
  {
   	  $order = Order::find($id);
      $order->CustomerId = $request->get('CustomerId');
      $order->DetailId = $request->get('DetailId');
      $order->ProductId = $request->get('ProductId');
      $order->Price = $request->get('Price');
      $order->CreatedDate = $request->get('CreatedDate');
      $order->Status = $request->get('Status');
      $order->save();

      return redirect('/order');
   } 

  public function delete(Request $request, $id)
  {
    Order::findOrFail($id)->delete();
    return redirect('/order');
  }
}
