@extends('layouts.app')

@section('content')
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script src='https://cdn.rawgit.com/jackmoore/zoom/master/jquery.zoom.min.js'></script>
<style type="text/css">
	    .zoom {
display:inline-block;
position: relative;
}
.zoom img {
display: block;
}
.zoom img::selection { background-color: transparent; }
</style>


<div class="container-fluid" >
    <div class="well well-lg" style="background-color: #edf7f7">
   <h1 style="font-family: IBM Plex Serif" id="tittle"></h1>
  <hr>   
      <div class="row">
        <div class="col-md-5">
          <div class="well well-lg" style="text-align: center; background-color: white"> 
            <div>
				 <span class='zoom' id='zoom1'>
   					 <img src="http://static.webpie.net/files/11/_p/890/jquery-zoom.jpg" width='100' height='100'/>
				</span>
			</div>

			<ul class="thumbnails">
				<li>
					<img src="" alt="" />					
				</li>
				<li>
					<img src=""/>			
				</li>
				<li>
					<img src=""/>
				</li>
				<li>			
					<img src=""/>				
				</li>
			</ul>

          </div>
      </div>
      <div class="col-md-7" style="text-align: left">
          <div class="well well-lg" style="background-color: white">
            <h3 style="text-align: center; color: red" id="tittle">Name</h3>
          <span style="text-align: center;"><h4 id="price">Price</h4></span>
          <hr>
          <br>
          <span style="color: green">SPECIFICATIONS </span>
                <p id="special1"></p>
                <p id="special2"></p>
          <span style="color: green">DESCRIPTION</span> 
          <p id="DESCRIPTION1"></p>
          <p id="DESCRIPTION2"></p>
          <p id="DESCRIPTION3"></p>

      <hr>
      Tags: 
      <br>
      <div>
              <span>Quantity:</span>
                <br>
                <input id="qty" type="number" name="qty" value="1" min="1" max="1000">
                <button id="addcart" class="btn btn-info my-cart-btn" data-id="" data-name="" data-price="" data-quantity="" data-image=""><span class="glyphicon glyphicon-shopping-cart"></span>Add to Cart</button>
            </div> 
    </div>
      </div>
  </div>
  </div>
</div>
</div>



<script type="text/javascript">
$(document).ready(function(){
  $('#zoom1').zoom();
});
</script>



@endsection
