@extends('layouts.app')
<script src="{{ asset('ckeditor/ckeditor.js') }}"></script>
<script> CKEDITOR.replace('editor'); </script>
<script type="ckeditor/ckeditor.js"></script>
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
    <form action="{{ isset($data) ? url('/news/update',[$data->id]) : url('/editnews') }}" method="POST" class="form-horizontal">
      {{ csrf_field() }}
      <input type="hidden" name="id" id="id" value="{{isset($data) ? $data->id: 0}}" />
      <!-- Task Name -->
      <div class="form-group">
        <label for="name" class="col-sm-3 control-label">Tittle</label>
        <div class="col-sm-6">
          <input type="text" name="tittle" id="tittle" value="{{isset($data) ? $data->tittle: ''}}" class="form-control">
        </div>
      </div>
      <div class="form-group">
        <label for="name" class="col-sm-3 control-label">Images</label>
        <div class="col-sm-6">
          <input type="file" name="images" id="images" class="form-control" value="{{isset($data) ? $data->images: ''}}">
        </div>
      </div>
      <div class="form-group">
        <label for="name" class="col-sm-3 control-label">Content</label>
        <div class="col-sm-6">
          <textarea name="txtContent" class="editor " id="editor" value="{{isset($data) ? $data->content: ''}}">
          </textarea>

          <script type="text/javascript">CKEDITOR.replace('editor')</script>
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

          <a class="btn btn-primary" href="{{url('/news')}}">Back</a>
        </div>
      </div>
    </form>
  </div>
</div>
@endsection
