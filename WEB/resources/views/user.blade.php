@extends('layouts.app')
@section('content')

<div class="panel-body">
  <div class="container">
    @if (count($data) >= 0)
      <div class="panel panel-default">
          <div class="panel-body">
              <a class="btn btn-primary" href="/user/add">Thêm người dùng</a>
              <a class="btn btn-primary" href="/listsp">Quản lý sản phẩm</a>
              <a class="btn btn-primary" href="/order">Thông tin đơn hàng</a>
              <br />
              <br />
              <br />
              <table class="table table-striped task-table">
                  <!-- Table Headings -->
                  <thead>
                      <th>Tên người dùng</th>
                      <th>Tuổi</th>
                      <th>Số điện thoại</th>
                      <th>Email</th>
                      <th>Địa chỉ</th>
                      <th>Sửa</th>
                      <th>Xóa</th>
                  </thead>
                  <!-- Table Body -->
                  <tbody>
                      @foreach ($data as $nguoidung)
                          <tr>
                              <!-- Task Name -->
                              <td class="table-text">
                                  <div>{{ $nguoidung->name }}</div>
                              </td>                            
                               <td class="table-text">
                                <div>{{ $nguoidung->age }}</div>
                            </td>   
                            <td class="table-text">
                                <div>{{ $nguoidung->phone }}</div>
                            </td>    
                            <td class="table-text">
                                  <div>{{ $nguoidung->email }}</div>
                              </td>                      
                              <td class="table-text">
                                  <div>{{ $nguoidung->address }}</div>
                              </td>
                          
                              <td style="width:30px">
                                <a class="btn btn-danger" href="{{ url('/user/add/'.$nguoidung->id) }}">Sửa</a>
                              </td>
                              <td style="width:30px">
                                <a class="btn btn-danger" href="{{ url('/user/delete/'.$nguoidung->id) }}">Xóa</a>
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
