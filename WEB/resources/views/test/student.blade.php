@extends('layouts.default')

@section('title', 'Tạo sản phẩm')

@section('content')
    @if(isset($success))
		<div class="alert alert-success" role="alert">{{ $success }}</div>
    @endif
    @if(isset($fail))
		<div class="alert alert-danger" role="alert">{{ $fail }}</div>
    @endif

    {!! Form::open(array('url' => '/product', 'class' => 'form-horizontal')) !!}
      <div class="form-group">
         {!! Form::label('name', 'Tên sinh viên', array('class' => 'col-sm-3 control-label')) !!}
         <div class="col-sm-9">
            {!! Form::text('name', '', array('class' => 'form-control')) !!}
         </div>
      </div>

      <div class="form-group">
         {!! Form::label('gender', 'Giới tính', array('class' => 'col-sm-3 control-label')) !!}
         <div class="col-sm-3">
            {!! Form::text('gender', '', array('class' => 'form-control')) !!}
         </div>
      </div>

      <div class="form-group">
         {!! Form::label('address', 'Địa chỉ', array('class' => 'col-sm-3 control-label')) !!}
         <div class="col-sm-9">
            {!! Form::textarea('address', '', array('class' => 'form-control', 'rows' => 3)) !!}
         </div>
      </div>

      <div class="form-group">
         {!! Form::label('phone', 'Điện thoại', array('class' => 'col-sm-3 control-label')) !!}
         <div class="col-sm-9">
            {!! Form::text('phone', '', array('class' => 'form-control')) !!}
         </div>
      </div>
      
      <div class="form-group">
         {!! Form::label('active', 'Active', array('class' => 'col-sm-3 control-label')) !!}
         <div class="col-sm-3">
            {!! Form::checkbox('active', '', true) !!}
         </div>
      </div>  

      <div class="form-group">
         <div class="col-sm-offset-2 col-sm-10">
            {!! Form::submit('Thêm mới sinh viên', array('class' => 'btn btn-success')) !!}
         </div>
      </div>
   {!! Form::close() !!}
@endsection