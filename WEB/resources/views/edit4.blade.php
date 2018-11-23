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
      <form action="{{ isset($data) ? url('/order/update') : url('/edit4') }}" method="POST" class="form-horizontal">
          {{ csrf_field() }}
          <input type="hidden" name="id" id="id" value="{{isset($data) ? $data->id: 0}}" />
          <!-- Task Name -->
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">DetailId</label>
              <div class="col-sm-6">
                  <input type="text" name="DetailId" id="DetailId" value="{{isset($data) ? $data->DetailId: ''}}" class="form-control">
              </div>
          </div>
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">CustomerId</label>
              <div class="col-sm-6">
                  <input type="text" name="CustomerId" id="CustomerId" class="form-control" value="{{isset($data) ? $data->CustomerId: ''}}">
              </div>
          </div>
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">ProductId</label>
              <div class="col-sm-6">
                  <input type="text" name="ProductId" id="ProductId" class="form-control" value="{{isset($data) ? $data->ProductId: ''}}">
              </div>
          </div>
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">Price</label>
              <div class="col-sm-6">
                  <input type="text" name="Price" id="Price" class="form-control" value="{{isset($data) ? $data->Price: ''}}">
              </div>
          </div>
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">CreatedDate</label>
              <div class="col-sm-6">
                  <input type="text" name="CreatedDate" id="CreatedDate" class="form-control" value="{{isset($data) ? $data->CreatedDate: ''}}">
              </div>
          </div>
          <div class="form-group">
              <label for="name" class="col-sm-3 control-label">Status</label>
              <div class="col-sm-6">
                  <input type="text" name="Status" id="Status" class="form-control" value="{{isset($data) ? $data->Status: ''}}">
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

                  <a class="btn btn-primary" href="{{url('/orders')}}">Back</a>
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
							'DetailId':$('input[name=DetailId]').val(),
							'CustomerId':$('input[name=CustomerId]').val(),
							'ProductId':$('input[name=ProductId]').val(),
							'Price':$('input[name=Price]').val(),
              'CreatedDate':$('input[name=CreatedDate]').val(),
              'Status':$('input[name=Status]').val()
						},
						success:function(data){
							alert('Thêm mới đơn hàng thành công!');
              setTimeout(function() {
                $('#processebar').html('');                
              }, 5000);

						},
			});
      return false;
    });
</script>
@endsection
