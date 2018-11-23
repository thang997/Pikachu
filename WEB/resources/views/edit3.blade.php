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
      <form action="{{ isset($data) ? url('/user/update',[$data->id]) : url('/edit3') }}" method="POST" class="form-horizontal">
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
              <label for="name" class="col-sm-3 control-label">Age</label>
              <div class="col-sm-6">
                  <input type="text" name="age" id="age" class="form-control" value="{{isset($data) ? $data->age: ''}}">
              </div>
          </div>
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">Phone</label>
              <div class="col-sm-6">
                  <input type="text" name="phone" id="phone" class="form-control" value="{{isset($data) ? $data->phone: ''}}">
              </div>
          </div>
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">Email</label>
              <div class="col-sm-6">
                  <input type="text" name="email" id="email" class="form-control" value="{{isset($data) ? $data->email: ''}}">
              </div>
          </div>
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">Address</label>
              <div class="col-sm-6">
                  <input type="text" name="address" id="address" class="form-control" value="{{isset($data) ? $data->address: ''}}">
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

                  <a class="btn btn-primary" href="{{url('/user')}}">Back</a>
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
							'name':$('input[name=name]').val(),
							'age':$('input[name=price]').val(),
							'phone':$('input[name=picture]').val(),
							'email':$('input[name=order]').val(),
              'address':$('input[name=order]').val()
						},
						success:function(data){
							alert('Thêm mới người dùng thành công!');
              setTimeout(function() {
                $('#processebar').html('');                
              }, 5000);

						},
			});
      return false;
    });
</script>
@endsection
