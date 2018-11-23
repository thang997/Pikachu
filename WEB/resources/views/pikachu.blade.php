
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
				<a class="navbar-brand" href="#">
					<h1>PIKACHU</h1>
				</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse navbar-right navbar-main-collapse">
				<ul class="nav navbar-nav">
					<li><a href="#about">About</a></li>
					<li><a href="#news">News</a></li>
					<li><a href="#play">How to play</a></li>
					<li><a href="#score">Top Score</a></li>
					<li><a href="#contact">Contact</a></li>
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

<!-- Section: about -->
<section id="about" class="home-section text-center">
	<div class="heading-about">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow bounceInDown" data-wow-delay="0.4s">
						<div class="section-heading">
							<h2>About us</h2>
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
			<div class="col-md-3">
				<div class="wow bounceInUp" data-wow-delay="0.2s">
					<div class="team boxed-grey">
						<div class="inner">
							<h5>Lê Hoàng</h5>
							<div class="avatar"><img src="/images/pikachu/team/1.jpg" alt="" class="img-responsive img-circle" /></div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="wow bounceInUp" data-wow-delay="0.5s">
					<div class="team boxed-grey">
						<div class="inner">
							<h5>Nguyễn Thắng</h5>
							<div class="avatar"><img src="/images/pikachu/team/2.jpg" alt="" class="img-responsive img-circle" /></div>

						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="wow bounceInUp" data-wow-delay="0.8s">
					<div class="team boxed-grey">
						<div class="inner">
							<h5>Quốc Việt</h5>
							<div class="avatar"><img src="/images/pikachu/team/3.jpg" alt="" class="img-responsive img-circle" /></div>

						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3">
				<div class="wow bounceInUp" data-wow-delay="1s">
					<div class="team boxed-grey">
						<div class="inner">
							<h5>Bulbasaur</h5>
							<div class="avatar"><img src="/images/pikachu/team/4.jpg" alt="" class="img-responsive img-circle" /></div>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /Section: about -->


<!-- Section: services -->
<section id="news" class="home-section text-center bg-gray">

	<div class="heading-about">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow bounceInDown" data-wow-delay="0.4s">
						<div class="section-heading">
							<a href="/tintuc"><h2>News</h2></a>
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
			<div class="col-lg-6">
				<div class="wow fadeInLeft" data-wow-delay="0.2s">
					<div class="service-box">
						<div class="service-icon">
							<img src="/images/pikachu/pikachu1.jpg" alt="" />
						</div>
						<div class="service-desc">
							<a href=""><h5>Collect Your Favorites from Kanto</h5></a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="wow fadeInUp" data-wow-delay="0.2s">
					<div class="service-box">
						<div class="service-icon">
							<img src="/images/pikachu/pikachu2.jpg" alt="" />
						</div>
						<div class="service-desc">
							<a href=""><h5>Pokémon’s Spookiest Locales</h5></a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="wow fadeInUp" data-wow-delay="0.2s">
					<div class="service-box">
						<div class="service-icon">
							<img src="/images/pikachu/pikachu3.jpg" alt="" />
						</div>
						<div class="service-desc">
							<a href=""><h5>Halloween Bonuses in Pokémon Duel</h5></a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="wow fadeInRight" data-wow-delay="0.2s">
					<div class="service-box">
						<div class="service-icon">
							<img src="/images/pikachu/pikachu4.jpg" alt="" />
						</div>
						<div class="service-desc">
							<a href=""><h5>Research the Wonderful Shedinja</h5></a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /Section: services -->

<!-- 	How to play -->
<section id="play" class="home-section text-center bg-gray">
	<div class="heading-about">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow bounceInDown" data-wow-delay="0.4s">
						<div class="section-heading">
							<h2>How to play</h2>
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
			<div class="col-sm-4 col-md-4 col-lg-4 container">
				<img src="/images/pikachu3.png" id="howtoplay">
			</div>
			<div class="col-sm-8 col-md-8 col-lg-8 container" id="htp">
				<span>	Pikachu Games - The best classic pikachu game without installation
					Pikachu is a classic game that has received a lot of love from not only young people but also older people. Coming to the classic version of this classic pikachu game we will explore the game very interesting.
				</span>

				<span>
					This time of year Pikachu game will be a difficult challenge for you!
				</span>
				<br>
				<span>
					Discover the old version of the game Pikachu attractive, although there are many other versions of pikachu have more beautiful images, but many still remain loyal to the ancient pikachu game. By simply, less glare by graphic images.
				</span>
				<br>
				<span>
					Sure people still remember how to play? In the pikachu game, your task is to find pairs of identical shapes to connect pairs of pikachu not more than 2 times to eliminate them, the game ends when all pairs of pikachu online in the game.
				</span>
				<br>
				<span>
					Finding pikachu in the game can help you improve your reflexes and train your eyes well.
				</span>
				<br>
				<span>
					Classic pikachu game:
					Use mouse to perform actions.
				</span>
				<br>
				<span>
					The game will automatically save after each level of play.
				</span>
				<br>
				<span>
					I want you to catch many pikachu games !!!
				</span>
			</div>
		</div>
	</div>
</section>
<!-- 	Top score -->
<section id="score" class="home-section text-center bg-gray">
	<div class="heading-about">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow bounceInDown" data-wow-delay="0.4s">
						<div class="section-heading">
							<h2>Top Score</h2>
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
			<div class="col-sm-12 col-md-12 col-lg-12 container">
				<div class="panel panel-default">
					<div class="panel-body">
						<table class="blueTable table-striped task-table">
							<thead>
								<th>Avatar</th>
								<th>Name</th>
								<th>Score</th>
								<th>Rank</th>
							</thead>
							<!-- Table Body -->
							<tbody>
								@foreach ($data as $key =>$users)
								<tr>
									<!-- Task Name -->
									<td>
										<img src="/images/pikachu/{{ $users->avatar }}" style="width: 50px">
									</td>
									<td>{{ $users->name }}</td>                
									<td>{{ $users->score }}</td>
									@if($key =="0")
									<td><img src="/images/pikachu/gold.gif" style="width: 50px"></td>             
									@endif
									@if($key =="1")
									<td><img src="/images/pikachu/silver.gif" style="width: 50px"></td>               
									@endif
									@if($key =="2")
									<td><img src="/images/pikachu/bronze.gif" style="width: 50px"></td>               
									@endif
									@if($key =="4")
									<td></td>
									@endif   
									@if($key =="3")
									<td></td>  
									@endif            
								</tr>	
								@endforeach
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</section>

<!-- Section: contact -->
<section id="contact" class="home-section text-center">
	<div class="heading-contact">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<div class="wow bounceInDown" data-wow-delay="0.4s">
						<div class="section-heading">
							<h2>Contact</h2>
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
			<div class="col-lg-8">
				<div class="boxed-grey">
					<form id="contact-form" method="post" role="form" class="contactForm">
						{{ csrf_field() }}s
						<div class="row">
							<div class="col-md-6">
								
								<div class="form-group">
									<label for="name">Name</label>
									<input type="text" name="name" class="form-control" id="name" placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
									<div class="validation"></div>
								</div>

								<div class="form-group">
									<label for="email">Email Address</label>
									<div class="form-group">
										<input type="email" class="form-control" name="email" id="email" placeholder="Your Email" data-rule="email" data-msg="Please enter a valid email" />
										<div class="validation"></div>
									</div>
								</div>

								<div class="form-group">
									<label for="subject">Subject</label>
									<input type="text" class="form-control" name="subject" id="subject" placeholder="Subject" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
									<div class="validation"></div>
								</div>
							</div>

							<div class="col-md-6">
								<div class="form-group">
									<label for="name">Message</label>
									<textarea class="form-control" id="message" name="message" rows="5" data-rule="required" data-msg="Please write something for us" placeholder="Message"></textarea>
									<div class="validation"></div>
								</div>
							</div>

							<div class="col-md-12">
								<button type="submit" class="btn btn-skin pull-right" id="btnContactUs" value="Send Message">
								Send Message</button>
							</div>
						</div>
					</form>
				</div>
			</div>

			<div class="col-lg-4">
				<div class="widget-contact">
					<h5>Main Office</h5>

					<address>
						<strong>Squas Design, Inc.</strong><br>
						Detech tower, 8th Ton That Thuyet, My Dinh<br>
						Cau Giay, Ha Noi<br>
						<span title="Phone">Phone:</span> (+84) 12345678
					</address>

					<address>
						<strong>Email</strong><br>
						<a href="mailto:#">pikachu@gmail.com</a>
					</address>
					<address>
						<strong>We're on social networks</strong><br>
						<ul class="company-social">
							<li class="social-facebook"><a href="#"><i class="fab fa-facebook"></i></a></li>
							<li class="social-twitter"><a href="#"><i class="fab fa-twitter"></i></a></li>
							<li class="social-instagram"><a href="#"><i class="fab fa-instagram"></i></a></li>
							<li class="social-google"><a href="#"><i class="fab fa-google-plus"></i></a></li>
						</ul>
					</address>
				</div>
			</div>
		</div>

	</div>
</section>
<!-- /Section: contact -->

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



