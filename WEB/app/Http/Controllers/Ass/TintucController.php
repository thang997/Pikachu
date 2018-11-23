<?php

namespace App\Http\Controllers\Ass;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use DB;

class TintucController extends Controller
{
  public function index7()
  {
    $news = DB::table('news')->paginate(8);

    return view('tintuc', ['data' => $news]);
  }


}



