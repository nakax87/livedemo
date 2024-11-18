<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class AddNewColumnsToEventsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::table('events', function (Blueprint $table) {
            // Add new columns if they don't exist
            if (!Schema::hasColumn('events', 'title')) {
                $table->string('title', 255)->after('id')->nullable(false);
            }
            if (!Schema::hasColumn('events', 'description')) {
                $table->text('description')->after('title')->nullable();
            }
            if (!Schema::hasColumn('events', 'start_date')) {
                $table->date('start_date')->after('description')->nullable();
            }
            if (!Schema::hasColumn('events', 'end_date')) {
                $table->date('end_date')->after('start_date')->nullable();
            }
            if (!Schema::hasColumn('events', 'recruitment_start_date')) {
                $table->date('recruitment_start_date')->after('end_date')->nullable();
            }
            if (!Schema::hasColumn('events', 'recruitment_end_date')) {
                $table->date('recruitment_end_date')->after('recruitment_start_date')->nullable();
            }
            if (!Schema::hasColumn('events', 'event_type')) {
                $table->string('event_type', 50)->after('recruitment_end_date')->nullable();
            }
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::table('events', function (Blueprint $table) {
            // Remove columns if they exist
            $table->dropColumn(['title', 'description', 'start_date', 'end_date', 'recruitment_start_date', 'recruitment_end_date', 'event_type']);
        });
    }
}
