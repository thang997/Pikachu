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
      <form action="{{ isset($data) ? url('/library/update') : url('/add1') }}" method="POST" class="form-horizontal">
          {{ csrf_field() }}

          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">BookID</label>
              <div class="col-sm-6">
                  <input type="text" name="bookid" id="bookid" value="{{isset($data) ? $data->bookid: ''}}" class="form-control">
              </div>
          </div>
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">AuthorID</label>
              <div class="col-sm-6">
                  <input type="text" name="authorid" id="authorid" class="form-control" value="{{isset($data) ? $data->authorid: ''}}">
              </div>
          </div>
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">Title</label>
              <div class="col-sm-6">
                  <input type="text" name="title" id="title" class="form-control" value="{{isset($data) ? $data->title: ''}}">
              </div>
          </div>
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">ISBN</label>
              <div class="col-sm-6">
                  <input type="text" name="isbn" id="isbn" class="form-control" value="{{isset($data) ? $data->isbn: ''}}">
              </div>
          </div>
           <div class="form-group">
              <label for="name" class="col-sm-3 control-label">Pub_year</label>
              <div class="col-sm-6">
                  <input type="text" name="pub" id="pub" class="form-control" value="{{isset($data) ? $data->pub_year: ''}}">
              </div>
          </div>
           <div class="form-group">
              <label for="name" class="col-sm-3 control-label">Available</label>
              <div class="col-sm-6">
                  <input type="text" name="available" id="available" class="form-control" value="{{isset($data) ? $data->available: ''}}">
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

                  <a class="btn btn-primary" href="{{url('/library')}}">Back</a>
                  <button id="btnSave" type="button" class="btn btn-default">
                      <i class="fa fa-plus"></i> Add Task With Ajax
                  </button>
              </div>
          </div>
      </form>
    </div>
</div>

<script>
    jQuery('#btnSave').on('click', function(e){
      $('#processebar').html('Đang thực hiện....');
      $.ajax({
						type:'post',
						url: '/save',
						data:{
							'_token':$('input[name=_token]').val(),
							'bookid':$('input[name=bookid]').val(),
              'authorid':$('input[name=authorid]').val(),
              'title':$('input[name=title]').val(),
							'ISBN':$('input[name=ISBN]').val(),
							'pub_year':$('input[name=pub_year]').val(),
							'available':$('input[name=available]').val()
						},
						success:function(data){
							alert('Thêm mới sản phẩm thành công!');
              setTimeout(function() {
                $('#processebar').html('');                
              }, 5000);

						},
			});
      return false;
    });
</script>
@endsection
