@extends('layouts.app')

@section('content')

<div  class="container-fluid">
	<!-- BANNER -->
	<div id ="demo" class="carousel slide" data-ride="carousel">
  <ul class="carousel-indicators">
    <li data-target="#demo" data-slide-to="0" class="active"></li>
    <li data-target="#demo" data-slide-to="1"></li>
    <li data-target="#demo" data-slide-to="2"></li>
  </ul>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="https://topgadgetsuk.co.uk/wp-content/uploads/note9.png" style="width: 100%; height: 100%">
      <div class="carousel-caption">
        <h3></h3>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="https://cdn-a.production.news.bbm.static6.com/uploads/article/primary_image/557999/40f7079fab75239a.jpg" style="width: 100%; height: 100%">
      <div class="carousel-caption">
        <h3></h3>
      </div>   
    </div>
    <div class="carousel-item">
      <img src="https://n11scdn.akamaized.net/a1/org/elektronik/ekran-koruyucu/huawei-g7-g8-p7-p8-p9-p10-p20-pro-lite-plus-p-smart-kilif-isim__1049709382221400.jpg" style="width: 100%; height: 100%">
      <div class="carousel-caption">
        <h3></h3>
      </div>   
    </div>
  </div>
  <a class="carousel-control-prev" href="#demo" data-slide="prev">
    <span class="carousel-control-prev-icon"></span>
  </a>
  <a class="carousel-control-next" href="#demo" data-slide="next">
    <span class="carousel-control-next-icon"></span>
  </a>
</div>

<br>
  </div>
  <div class="container-fluid">
	<div class="row"> </div>
  <div class = "container-fluid">
    <div class="categoryName">Điện thoại</div>
    <div class="viewMoreButton"><a href=""><button type="button" class="btn btn-danger" style="margin-right: 50px">Xem thêm</button></a></div>
      </div>
  	<hr style="margin-top:3px">
</div>

    <!-- Item Điện thoại -->

    <div class="container-fluid">
  <div class="row">
  
      @foreach ($data as $sanpham)
     @if($sanpham->type == "mobile")
      <div class="col-sm-3 col-md-6 col-lg-3 container demo-7">
    <ul class="grid cs-style-7">
        <li>
          <figure>
            <img src="{{ $sanpham->picture}}" alt="img06">
              <div>{{ $sanpham->name }}</div>
            <figcaption>
              <h3>{{ $sanpham->name }}</h3>
              <span>{{ $sanpham->price }}</span>
              <p> <input type="image" name="submit"
                    src="https://www.paypalobjects.com/en_US/i/btn/btn_cart_LG.gif"
                    alt="Add to Cart">
                <img alt="" width="1" height="1"
                    src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" ></p>
           </figcaption>
          </figure>
        </li>
      </ul>
    </div>
           @endif
    @endforeach
  </div>
</div>


	<br>
<!-- 	Item Tablet -->
	<div class="container-fluid">
	<div class="row"></div>
  <br><br>
  <div class = "container-fluid">
    <div class="categoryName">Máy tính bảng</div>
    <div class="viewMoreButton"><a href=""><button type="button" class="btn btn-danger" style="margin-right: 50px">Xem thêm</button></a></div>
      </div>
  	<hr style="margin-top:3px">
</div>
     <div class="container-fluid">
  <div class="row">
  
      @foreach ($data as $sanpham)
     @if($sanpham->type == "tablet")
      <div class="col-sm-3 col-md-6 col-lg-3 container demo-7">
    <ul class="grid cs-style-7">
        <li>
          <figure>
            <img src="{{ $sanpham->picture}}" alt="img06">
              <div>{{ $sanpham->name }}</div>
            <figcaption>
              <h3>{{ $sanpham->name }}</h3>
              <span>{{ $sanpham->price }}</span>
              <p> <input type="image" name="submit"
                    src="https://www.paypalobjects.com/en_US/i/btn/btn_cart_LG.gif"
                    alt="Add to Cart">
                <img alt="" width="1" height="1"
                    src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" ></p>
           </figcaption>
          </figure>
        </li>
      </ul>
    </div>
           @endif
    @endforeach
  </div>
</div>
	<br>

<!-- 	Item Accessori -->
  <div class="container-fluid">
  <div class="row"></div>
  <br><br>
  <div class = "container-fluid">
    <div class="categoryName">Phụ kiện</div>
    <div class="viewMoreButton"><a href=""><button type="button" class="btn btn-danger" style="margin-right: 50px">Xem thêm</button></a></div>
      </div>
    <hr style="margin-top:3px">
</div>
  <div class="container-fluid">
	<div class="row">
  
      @foreach ($data as $sanpham)
     @if($sanpham->type == "pk")
      <div class="col-sm-3 col-md-6 col-lg-3 container demo-7">
    <ul class="grid cs-style-7">
        <li>
          <figure>
            <img src="{{ $sanpham->picture}}" alt="img06">
              <div>{{ $sanpham->name }}</div>
            <figcaption>
              <h3>{{ $sanpham->name }}</h3>
              <span>{{ $sanpham->price }}</span>
              <p> <input type="image" name="submit"
                    src="https://www.paypalobjects.com/en_US/i/btn/btn_cart_LG.gif"
                    alt="Add to Cart">
                <img alt="" width="1" height="1"
                    src="https://www.paypalobjects.com/en_US/i/scr/pixel.gif" ></p>
           </figcaption>
          </figure>
        </li>
      </ul>
    </div>
           @endif
    @endforeach
  </div>
</div>
@endsection
