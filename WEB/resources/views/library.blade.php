@extends('layouts.app')

@section('content')

<div class="panel-body">
  <div class="container">
    @if (count($data) >= 0)
      <div class="panel panel-default">
          <div class="panel-body">
              <a class="btn btn-primary" href="/add1">Thêm sản phẩm</a>
              <form method="GET" action="search" accept-charset="UTF-8">
            <div id="custom-search-input">
                <div class="input-group col-md-12">
                    <input  type="text" name="title" class="form-control input-lg" placeholder="Enter Title or ISBN" />
                    <span class="input-group-btn" >
                        <button  class="btn btn-info btn-lg" type="submit" style="margin-top: 41px">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </span>
                </div>
            </div>
            </form>
              <br />
              <br />
              <br />
              <table class="table table-striped task-table">
                  <!-- Table Headings -->
                  <thead>
                      <th>BookID</th>
                      <th>AuthorID</th>
                      <th>Title</th>
                      <th>ISBN</th>
                      <th>Pub_year</th>
                      <th>Avaiable</th>
                      <th>Sửa</th>
                      <th>Xóa</th>
                  </thead>
                  <!-- Table Body -->
                  <tbody>
                      @foreach ($data as $books)
                          <tr>
                              <!-- Task Name -->
                              <td class="table-text">
                                  <div>{{ $books->bookid }}</div>
                              </td class="table-text">                            
                               <td>
                                <div>{{ $books->authorid }}</div>
                            </td>      
                            <td class="table-text">
                                  <div>{{ $books->title }}</div>
                              </td>                      
                              <td class="table-text">
                                  <div>{{ $books->ISBN }}</div>
                              </td>
                               <td class="table-text">
                                  <div>{{ $books->pub_year }}</div>
                              </td>
                               <td class="table-text">
                                  <div>{{ $books->avaiable }}</div>
                              </td>

                              <td style="width:30px">
                                <a class="btn btn-danger" href="{{ url('/add1/'.$books->bookid) }}">Sửa</a>
                              </td>
                              <td style="width:30px">
                                <a class="btn btn-danger" href="{{ url('/library/delete/'.$books->bookid) }}">Xóa</a>
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
