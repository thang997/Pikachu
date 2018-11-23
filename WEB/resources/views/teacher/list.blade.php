@extends('layouts.app')

@section('content')

<div class="panel-body">
  <div class="container">
    @if (count($data) > 0)
      <div class="panel panel-default">
          <div class="panel-body">
              <a class="btn btn-primary" href="/product/add">Add Product</a>
              <br />
              <br />
              <br />
              <table class="table table-striped task-table">
                  <!-- Table Headings -->
                  <thead>
                      <th>Product Name</th>
                      <th>Price</th>
                      <th>Picture</th>
                      <th>Email</th>
                      <th>Order</th>
                      <th>Edit</th>
                      <th>Delete</th>
                  </thead>
                  <!-- Table Body -->
                  <tbody>
                      @foreach ($data as $product)
                          <tr>
                              <!-- Task Name -->
                              <td class="table-text">
                                  <div>{{ $product->name }}</div>
                              </td>
                              <td class="table-text">
                                  <div>{{ $product->price }}</div>
                              </td>
                             
                              <td class="table-text">
                                  <div>{{ $product->email }}</div>
                              </td>
                          
                              <td style="width:30px">
                                <a class="btn btn-danger" href="{{ url('/product/add/'.$product->id) }}">Edit</a>
                              </td>
                              <td style="width:30px">
                                <a class="btn btn-danger" href="{{ url('/product/delete/'.$product->id) }}">Delete</a>
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
