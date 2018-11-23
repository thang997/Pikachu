@extends('layouts.admin')
@section('content')
@if (count($data) >= 0)
<div class="panel panel-default">
  <div class="panel-body">
    <div class="col-sm-12">
      <form class="form-inline" action='{{ url("search") }}' method="POST">
        <div class="form-group">
          {{ csrf_field()}}
          <label for="email">Email:</label>
          <input type="email" class="form-control" placeholder="Enter email" name="email">
        </div>
        <div class="form-group">
          <label for="name">Full Name:</label>
          <input type="text" class="form-control" placeholder="Enter name" name="name">
        </div>
        <div class="form-group">
          <label for="score">Choose Score:</label>
          <select class="form-control" name="score">
            <option value="0">Score</option>
            <option value="1">0 - 2k</option>
            <option value="2">2k - 4k</option>
            <option value="3">4k - 6k</option>
            <option value="4">> 6k</option>
          </select> 
        </div>  
        <button type="submit" class="btn btn-default" name="search">Search</button>
      </form>
    </div>

    <table class="table table-striped task-table">
      <thead>
        <th>Name</th>
        <th>Email</th>
        <th>Avatar</th>
        <th>Score</th>
        <th>Status</th>
        <th></th>
        <th></th>
        <th>Edit</th>
        <th>Delete</th>
      </thead>
      <!-- Table Body -->
      <tbody>
        @foreach ($data as $user)
        <tr>
          <!-- Task Name -->
          <td class="table-text">
            <div>{{ $user->name }}</div>
          </td>   
          <td class="table-text">
            <div>{{ $user->email }}</div>
          </td>                         
          <td>
            <img src="/images/pikachu/{{ $user->avatar }}" width="120" height="120">
          </td>                            
          <td class="table-text">
            <div>{{ $user->score }}</div>
          </td>
          <td>@if ($user->lock == 1) lock    
            @else unlock  
            @endif
          </td>
          <td>
            <a href='{{ url("lock/$user->id") }}'><span class="glyphicon glyphicon-lock"></span></a>
          </td>
          <td>
            <a href='{{ url("unlock/$user->id") }}'><span class="glyphicon glyphicon-ok"></a>
            </td>


            <td style="width:30px">
              <a class="btn btn-danger" href="{{ url('/add/'.$user->id) }}">Edit</a>
            </td>
            <td style="width:30px">
              <a class="btn btn-danger" href="{{ url('/delete/'.$user->id) }}">Delete</a>
            </td>
          </tr>
          @endforeach
        </tbody>
      </table>
      {{ $data->links() }}
    </div>
  </div>
  @endif
  @endsection