
<title>PIKACHU</title>

<!-- Bootstrap Core CSS -->
<link href="/css/pikachu/bootstrap.min.css" rel="stylesheet" type="text/css">

<!-- Fonts -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
<link href="/css/pikachu/animate.css" rel="stylesheet" />
<!-- Squad theme CSS -->
<link href="/css/pikachu/style.css" rel="stylesheet">

<body id="page-top" data-spy="scroll" data-target=".navbar-custom">

	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header page-scroll">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-main-collapse">
					<i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="/">
					<h1>PIKACHU</h1>
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-right navbar-main-collapse">
				<ul class="nav navbar-nav">
					<li><a href="/#about">About</a></li>
					<li><a href="#news">News</a></li>
					<li><a href="/#play">How to play</a></li>
					<li><a href="/#score">Top Score</a></li>
					<li><a href="/#contact">Contact</a></li>
					@guest

					<li class="nav-item">
						<a class="nav-link" href="{{ route('login') }}">{{ __('Login') }}</a>
					</li>
					<li class="nav-item">
						@if (Route::has('register'))
						<a class="nav-link" href="{{ route('register') }}">{{ __('Register') }}</a>
						@endif
					</li>
					@else
					<li class="nav-item dropdown">
						<a id="navbarDropdown" class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" v-pre>
							{{ Auth::user()->name }} <span class="caret"></span>
						</a>

						<div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="{{ route('logout') }}"
							onclick="event.preventDefault();
							document.getElementById('logout-form').submit();">
							{{ __('Logout') }}
						</a>

						<form id="logout-form" action="{{ route('logout') }}" method="POST" style="display: none;">
							@csrf
						</form>
					</div>
				</li>
				@endguest
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>

<!-- Section: intro -->
<section id="intro" class="intro">

	<div class="page-scroll">
		<a href="#news" class="btn btn-circle">
			<i class="fas fa-angle-double-down"></i>	
		</a>
	</div>
</section>
<!-- /Section: intro -->



<!-- Section: services -->
<section id="news" class="home-section text-center bg-gray">

	<div class="heading-about">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow bounceInDown" data-wow-delay="0.4s">
						<div class="section-heading">
							<h2>News</h2>
							<i class="fa fa-2x fa-angle-down"></i>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-2 col-lg-offset-5">
				<hr class="marginbot-50">
			</div>
		</div>
		<div class="row">
			@foreach ($data as $news)
			<div class="col-lg-6">
				<div class="wow fadeInLeft" data-wow-delay="0.2s">
					<div class="service-box">
						<div class="service-icon">
							<img src="/images/pikachu/{{ $news -> images }}" alt="" />
						</div>
						<div class="service-desc">
							<a href=""><h5>{{ $news -> tittle }}</h5></a>
						</div>
					</div>
				</div>
			</div>
			@endforeach
		</div>
	</div>
</section>


<footer>
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-lg-12">
				<div class="wow shake" data-wow-delay="0.4s">
					<div class="page-scroll marginbot-30">
						<a href="#intro" id="totop" class="btn btn-circle">
							<i class="fa fa-angle-double-up animated"></i>
						</a>
					</div>
				</div>
				<p>&copy;PIKACHU 2018</p>
				<div class="credits">
            <!--
              All the links in the footer should remain intact. 
              You can delete the links only if you purchased the pro version.
              Licensing information: https://bootstrapmade.com/license/
              Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=Squadfree
          -->
          Designed by <a href="">Siro</a>
      </div>
  </div>
</div>
</div>
</footer>

<!-- Core JavaScript Files -->
<script src="/js/pikachu/jquery.min.js"></script>
<script src="/js/pikachu/bootstrap.min.js"></script>
<script src="/js/pikachu/jquery.easing.min.js"></script>
<script src="/js/pikachu/jquery.scrollTo.js"></script>
<script src="/js/pikachu/wow.min.js"></script>
<!-- Custom Theme JavaScript -->
<script src="/js/pikachu/custom.js"></script>

</body>



