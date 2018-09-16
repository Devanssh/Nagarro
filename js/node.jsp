<script>
var cron = require('node-cron');
 
cron.schedule('* * * * *', function(){
  console.log('running a task every minute');
});
</script>
<script>
var cron = require('node-cron');
 
cron.schedule('1,2,4,5 * * * *', function(){
  console.log('running every minute 1, 2, 4 and 5');
});
</script>
<script>
var cron = require('node-cron');
 
cron.schedule('1-5 * * * *', function(){
  console.log('running every minute to 1 from 5');
});
</script>
<script>
var cron = require('node-cron');
 
cron.schedule('*/2 * * * *', function(){
  console.log('running a task every two minutes');
});
</script>
<script>
var cron = require('node-cron');
 
cron.schedule('* * * January,September Sunday', function(){
  console.log('running on Sundays of January and September');
});
</script>

<script>
var cron = require('node-cron');
 
var task = cron.schedule('* * * * *', function() {
  console.log('immediately started');
}, false);
 
task.start();</script>
<script>
var cron = require('node-cron');
 
var task = cron.schedule('* * * * *', function() {
  console.log('will execute every minute until stopped');
});
 
task.stop();
</script>
<script>
var cron = require('node-cron');
 
var task = cron.schedule('* * * * *', function() {
  console.log('will not execute anymore, nor be able to restart');
});
 
task.destroy();
</script>
<script>
var cron = require('node-cron');
 
var valid = cron.validate('59 * * * *');
var invalid = cron.validate('60 * * * *');
</script>