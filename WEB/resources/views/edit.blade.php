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
      <form action="{{ isset($data) ? url('/product/update') : url('/product/save') }}" method="POST" class="form-horizontal">
          {{ csrf_field() }}
          <input type="hidden" name="id" id="product-id" value="{{isset($data) ? $data->id: 0}}" />
          <!-- Task Name -->
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">Product name</label>
              <div class="col-sm-6">
                  <input type="text" name="name" id="product-name" value="{{isset($data) ? $data->name: ''}}" class="form-control">
              </div>
          </div>
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">Price</label>
              <div class="col-sm-6">
                  <input type="text" name="price" id="price" class="form-control" value="{{isset($data) ? $data->price: ''}}">
              </div>
          </div>
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">Company Email</label>
              <div class="col-sm-6">
                  <input type="text" name="email" id="email" class="form-control" value="{{isset($data) ? $data->email: ''}}">
              </div>
          </div>
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">Order</label>
              <div class="col-sm-6">
                  <input type="text" name="order_id" id="order_id-name" class="form-control" value="{{isset($data) ? $data->order_id: ''}}">
              </div>
          </div>

          <!-- Add Task Button -->
          <div class="form-group">
              <div class="col-sm-offset-3 col-sm-6">
                @if (isset($data))
                  <button type="submit" class="btn btn-default">
                      <i class="fa fa-plus"></i> Update Task
                  </button>
                @else
                  <button type="submit" class="btn btn-default">
                      <i class="fa fa-plus"></i> Add Task
                  </button>
                @endif

                  <a class="btn btn-primary" href="{{url('/product/list')}}">Back</a>
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
						url: '/product/save',
						data:{
							'_token':$('input[name=_token]').val(),
							'name':$('input[name=name]').val(),
							'price':$('input[name=price]').val(),
							'email':$('input[name=email]').val(),
							'order_id':$('input[name=order_id]').val()
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
