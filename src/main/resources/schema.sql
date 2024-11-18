use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateEventsAndEventCustomFieldsTables extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('events', function (Blueprint $table) {
            $table->bigIncrements('id');
            $table->string('name', 255);
            $table->date('event_date');
            $table->integer('registrations')->default(0);
            $table->string('status', 50)->nullable();
            $table->decimal('satisfaction_rate', 2, 1)->nullable();
            $table->integer('revenue')->default(0);
            $table->timestamps(); // This will create both created_at and updated_at columns
        });

        Schema::create('event_custom_fields', function (Blueprint $table) {
            $table->bigIncrements('id');
            $table->timestamps(); // This will create both created_at and updated_at columns
            $table->string('field_name', 255);
            $table->string('field_type', 255);
            $table->boolean('is_required');
            $table->unsignedBigInteger('event_id');
            $table->foreign('event_id')->references('id')->on('events')->onDelete('cascade');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('event_custom_fields');
        Schema::dropIfExists('events');
    }
}
