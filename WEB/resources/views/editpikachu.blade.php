@extends('layouts.app')

@section('content')
<div class="container">
  <div class="panel-body">
    @if (count($errors) > 0)
    <div class="alert alert-danger">
      <ul>
        @foreach ($errors->all() as $error)
        <li>{{ $error }}</li>
        @endforeach
      </ul>
    </div>
    @endif
    <div id="processebar"></div>
    <!-- New Task Form -->
    <form action="{{ isset($data) ? url('/update',[$data->id]) : url('/editpikachu') }}" method="POST" class="form-horizontal">
      {{ csrf_field() }}
      <input type="hidden" name="id" id="id" value="{{isset($data) ? $data->id: 0}}" />
      <!-- Task Name -->
      <div class="form-group">
        <label for="name" class="col-sm-3 control-label">Name</label>
        <div class="col-sm-6">
          <input type="text" name="name" id="name" value="{{isset($data) ? $data->name: ''}}" class="form-control">
        </div>
      </div>
      <div class="form-group">
        <label for="email" class="col-sm-3 control-label">Email</label>
        <div class="col-sm-6">
          <input type="text" name="email" id="email" class="form-control" value="{{isset($data) ? $data->email: ''}}">
        </div>
      </div>
      <div class="form-group">
        <label for="avatar" class="col-sm-3 control-label">Avatar</label>
        <div class="col-sm-6">
          <input type="file" name="avatar" id="avatar" class="form-control" value="{{isset($data) ? $data->avatar: ''}}">
        </div>
      </div>
      <div class="form-group">
        <label for="name" class="col-sm-3 control-label">Score</label>
        <div class="col-sm-6">
          <input type="text" name="score" id="score" class="form-control" value="{{isset($data) ? $data->score: ''}}">
        </div>
      </div>

      <!-- Add Task Button -->
      <div class="form-group">
        <div class="col-sm-offset-3 col-sm-6">
          @if (isset($data))
          <button type="submit" class="btn btn-default">
            <i class="fa fa-plus"></i> Update
          </button>
          @else
          <button type="submit" class="btn btn-default">
            <i class="fa fa-plus"></i> Add
          </button>
          @endif

          <a class="btn btn-primary" href="{{url('/userpikachu')}}">Back</a>
        </div>
      </div>
    </form>
  </div>
</div>
@endsection
