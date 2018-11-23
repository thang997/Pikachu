<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

// Route::get('/', function () {
// 	return view('welcome');
// });

// Route::get('/home', function () {
// 	return view('welcome');
// });

//Khong yeu cau xac thuc
// Route::prefix('product')->group(function () {
//   Route::get('/list', 'Product\ProductController@index');
//   Route::get('/', 'Product\ProductController@index');
//   Route::get('/add/{id?}', 'Product\ProductController@add');
//   Route::get('/detail/{id}', 'Product\ProductController@get');
//   Route::get('/json/{id}', 'Product\ProductController@getjson');
//   Route::post('/save', 'Product\ProductController@save');
//   Route::get('/delete/{id}', 'Product\ProductController@delete');
// });

// Route::get('/product/list', 'Ass\ProductController@index');
// Route::get('/product/add/{id?}', 'Ass\ProductController@add');
// Route::get('/product/detail/{id}', 'Ass\ProductController@get');
// Route::get('/product/json/{id}', 'Ass\ProductController@getjson');
// Route::post('/product/save', 'Ass\ProductController@save');
// Route::get('/product/delete/{id}', 'Ass\ProductController@delete');


//Yeu cau xac thuc
// Route::get('product/{id}', [
// 		'middleware' => 'auth',
// 		'uses' => 'Product\ProductController@getProduct'
// ]);

// Route::middleware(['auth'])->group(function () {
//   Route::get('/product/list', 'Ass\ProductController@index');
//   Route::get('/product', 'Ass\ProductController@index');
//   Route::get('/product/add/{id?}', 'Ass\ProductController@add');
//   Route::get('/product/detail/{id}', 'Ass\ProductController@get');
//   Route::get('/product/json/{id}', 'Ass\ProductController@getjson');
//   Route::post('/product/save', 'Ass\ProductController@save');
//   Route::get('/product/delete/{id}', 'Ass\ProductController@delete');
// });

// Route::get('/login', 'function ()' {
//     return view('login');
// });
// Route::get('/detail', 				'Ass\AsController@index2');
// Route::get('/index', 				'Ass\AsController@index');
// Route::get('/snow', 				'Ass\AsController@index3');

// Route::get('/listsp', 				'Ass\AdminController@index');
// Route::get('/add/{id?}', 			'Ass\AdminController@add');
// Route::get('/detail/{id?}', 		'Ass\AdminController@get');
// Route::post('/edit2', 				'Ass\AdminController@save');
// Route::get('/delete/{id?}', 		'Ass\AdminController@delete');
// Route::post('/update/{id?}',		'Ass\AdminController@update');

// Route::get('/user', 				'Ass\MemberController@index');
// Route::get('/user/add/{id?}', 		'Ass\MemberController@add');
// Route::get('/user/delete/{id?}', 	'Ass\MemberController@delete');
// Route::post('/edit3', 				'Ass\MemberController@save');
// Route::post('/user/update/{id?}',	'Ass\MemberController@update');

// Route::get('/order', 				'Ass\OrderController@index');
// Route::get('/order/add/{id?}', 		'Ass\OrderController@add');
// Route::get('/order/delete/{id?}', 	'Ass\OrderController@delete');
// Route::post('/edit4', 				'Ass\OrderController@save');
// Route::post('/order/update/{id?}',	'Ass\OrderController@update');

// Route::get('/library', 				'Ass\LibraryController@index');
// Route::get('/search', 				'Ass\LibraryController@search');

// Route::get('/auth/facebook', 'SocialAuthController@redirectToProvider');
// Route::get('/auth/facebook/callback', 'SocialAuthController@handleProviderCallback');




Route::get('/', 					'Ass\AsController@index4');
Route::get('/tintuc', 				'Ass\TintucController@index7');

Route::get('/userpikachu', 			'Ass\AsController@index5')
->middleware('admin');
Route::get('/add/{id?}', 			'Ass\AsController@add')
->middleware('admin');
Route::post('/editpikachu', 		'Ass\AsController@save')
->middleware('admin');
Route::get('/delete/{id?}', 		'Ass\AsController@delete')
->middleware('admin');
Route::post('/update/{id?}',		'Ass\AsController@update')
->middleware('admin');
Route::get('/search1', 			'Ass\AsController@search')
->middleware('admin');

Route::get('/news', 				'Ass\NewsController@index6')
->middleware('admin');
Route::get('/news/add/{id?}', 		'Ass\NewsController@add')
->middleware('admin');
Route::post('/editnews', 			'Ass\NewsController@save')
->middleware('admin');
Route::get('/news/delete/{id?}', 	'Ass\NewsController@delete')
->middleware('admin');
Route::post('/news/update/{id?}',	'Ass\NewsController@update')
->middleware('admin');
Route::get('/search2', 			'Ass\NewsController@search')
->middleware('admin');

Route::post('/', 			'Ass\AsController@postContact');

Route::get('lock/{id}', 'Ass\AsController@lock');
Route::get('unlock/{id}', 'Ass\AsController@unlock');
//search
Route::post('search', 'Ass\AsController@postSearch');
Route::get('search', 'Ass\AsController@getSearch');


Auth::routes();
