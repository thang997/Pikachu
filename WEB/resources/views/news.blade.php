@extends('layouts.admin')

@section('content')
@if (count($data) >= 0)
<div class="panel panel-default">
  <div class="panel-body">
    <form method="GET" action="search2" accept-charset="UTF-8">
      <div id="custom-search-input">
        <div class="input-group col-md-12">
          <input  type="text" name="title" class="form-control input-lg" placeholder="Enter tittle" />
          <span class="input-group-btn" >
            <button  class="btn btn-info btn-lg" type="submit">
              Search
            </button>
          </span>
        </div>
      </div>
    </form>
    <a class="btn btn-primary" href="/news/add">Add news</a>
    <table class="table table-striped task-table">
      <thead>
        <th>Tittle</th>
        <th>Images</th>
        <th>Content</th>
        <th>Edit</th>
        <th>Delete</th>
      </thead>
      <!-- Table Body -->
      <tbody>
        @foreach ($data as $news)
        <tr>
          <!-- Task Name -->
          <td class="table-text">
            <div>{{ $news->tittle }}</div>
          </td>   
          <td>
            <img src="/images/pikachu/{{ $news->images }}" width="120" height="120">
          </td>    
          <td class="table-text">
            <div>{{ $news->content }}</div>
          </td>                         


          <td style="width:30px">
            <a class="btn btn-danger" href="{{ url('/news/add/'.$news->id) }}">Edit</a>
          </td>
          <td style="width:30px">
            <a class="btn btn-danger" href="{{ url('/news/delete/'.$news->id) }}">Delete</a>
          </td>
        </tr>
        @endforeach
      </tbody>
    </table>
  </div>
</div>

@endif
@endsection