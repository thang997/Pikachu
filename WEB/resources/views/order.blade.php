@extends('layouts.app')

@section('content')

<div class="panel-body">
  <div class="container">
    @if (count($data) >= 0)
      <div class="panel panel-default">
          <div class="panel-body">
              <a class="btn btn-primary" href="/order/add">Thêm đơn hàng</a>
              <a class="btn btn-primary" href="/listsp">Quản lý sản phẩm</a>
              <a class="btn btn-primary" href="/user">Quản lý người dùng</a>
              <br />
              <br />
              <br />
              <table class="table table-striped task-table">
                  <!-- Table Headings -->
                  <thead>
                      <th>Mã người dùng</th>
                      <th>Mã sản phẩm</th>
                      <th>Detail ID</th>
                      <th>Giá</th>
                      <th>Ngày tạo</th>
                      <th>Tình trạng</th>
                      <th>Sửa</th>
                      <th>Xóa</th>
                  </thead>
                  <!-- Table Body -->
                  <tbody>
                      @foreach ($data as $order)
                          <tr>
                              <!-- Task Name -->
                              <td class="table-text">
                                  <div>{{ $order->CustomerId }}</div>
                              </td>                            
                               <td class="table-text">
                                <div>{{ $order->DetailId }}</div>
                            </td>   
                            <td class="table-text">
                                <div>{{ $order->ProductId }}</div>
                            </td>    
                            <td class="table-text">
                                  <div>{{ $order->Price }}</div>
                              </td>                      
                              <td class="table-text">
                                  <div>{{ $order->CreatedDate }}</div>
                              </td>
                               <td class="table-text">
                                  <div>{{ $order->Status }}</div>
                              </td>
                          
                              <td style="width:30px">
                                <a class="btn btn-danger" href="{{ url('/order/add/'.$order->id) }}">Sửa</a>
                              </td>
                              <td style="width:30px">
                                <a class="btn btn-danger" href="{{ url('/order/delete/'.$order->id) }}">Xóa</a>
                              </td>
                          </tr>
                      @endforeach
                  </tbody>
              </table>
              {{ $data->links() }}
          </div>
      </div>
    @endif
  </div>
</div>
@endsection
