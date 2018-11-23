@extends('layouts.app')

@section('content')

<div class="panel-body">
  <div class="container">
    @if (count($data) >= 0)
      <div class="panel panel-default">
          <div class="panel-body">
              <a class="btn btn-primary" href="/add">Thêm sản phẩm</a>
              <a class="btn btn-primary" href="/user">Quản lý người dùng</a>
              <a class="btn btn-primary" href="/order">Thông tin đơn hàng</a>
              <br />
              <br />
              <br />
              <table class="table table-striped task-table">
                  <!-- Table Headings -->
                  <thead>
                      <th>Tên sản phẩm</th>
                      <th>Hình ảnh</th>
                      <th>Giá</th>
                      <th>Đặt hàng</th>
                      <th>Sửa</th>
                      <th>Xóa</th>
                  </thead>
                  <!-- Table Body -->
                  <tbody>
                      @foreach ($data as $sanpham)
                          <tr>
                              <!-- Task Name -->
                              <td class="table-text">
                                  <div>{{ $sanpham->name }}</div>
                              </td>                            
                               <td>
                                <img src="{{ $sanpham->picture }}" width="120" height="120">
                            </td>      
                            <td class="table-text">
                                  <div>{{ $sanpham->price }}</div>
                              </td>                      
                              <td class="table-text">
                                  <div>{{ $sanpham->order }}</div>
                              </td>
                          
                              <td style="width:30px">
                                <a class="btn btn-danger" href="{{ url('/listsp/add/'.$sanpham->id) }}">Sửa</a>
                              </td>
                              <td style="width:30px">
                                <a class="btn btn-danger" href="{{ url('/delete/'.$sanpham->id) }}">Xóa</a>
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
