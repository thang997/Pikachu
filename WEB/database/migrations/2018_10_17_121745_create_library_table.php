<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateLibraryTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('library', function (Blueprint $table) {
            $table->increments('bookid')->nullable(false);
            $table->integer('authorid')->default(0)->nullable(false);
            $table->string('title')->nullable(false);
            $table->string('ISBN')->nullable(false);
            $table->smallInteger('pub_year')->default(0)->nullable(false);
            $table->tinyInteger('avaiable')->nullable(false);
            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('library');
    }
}
