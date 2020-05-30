<div class="row custom_row">
   <div class="col-lg-6 my-auto">
      <div class="main_content mx-auto">
         <a href="about.html" target="_blank" class="text-white abt">
            <div data-tilt > <img src="images/logomain.png" style="width: 101px; height: 101px; margin-bottom: 70px; pointer-events: none;"/></div>
            <h3> Admission Portal Login </h3>
            <span> Click to know more </span> 
         </a>
      </div>
   </div>
   <div class="col-lg-6 my-auto">
      <div class="form_container">
         <form>
            <div class="form-group mail-tf"> <input type="email" id='email' class="form-control" name="email" placeholder="Email" title='Enter a valid e-mail address' required> <i class="fa fa-user"></i> </div>
            <div class="form-group pass-tf">
               <input type="password" class="form-control active" id="pass" placeholder="Password" title='Enter the password associated with your e-mail address' required> 
               <div id='eye' class='pass-tf' onclick="showPass()"><i class="fa fa-eye-slash" ></i></div>
            </div>
            <span id='mess' class="alert">Invalid Password</span><br><button type="button" class="log-btn" id='loginbtn'>Login</button> 
            <p class="message"> Forgot your password? <a href="#" onclick="return transfer_data()"> <b> Create a new password </b> </a> </p>
         </form>
         <form method="post" class="recaptcha_form" style="display: none;">
            <div class="form-group"> <input type="email" placeholder="Email" class="form-control" name="emailid" id="emailid" required> <i class="fa fa-user"></i> </div>
            <div class="form-group custom_group">
               <div id="recaptcha" class="g-recaptcha" data-sitekey="6LcmWcoUAAAAAI6AHCSSZCQFbovJ8opgL1AYPYG-"></div>
            </div>
            <p class="link"> <a href="resetpassword.html"> <b> I already have an OTP </b> </a> </p>
            <button type="submit"> Send OTP </button> 
            <p class="message"> Want to sign in? <a href="#"> <b> Sign in </b> </a> </p>
         </form>
      </div>
   </div>
</div>
<script defer src="js/scriptShake.js">
</script><script defer src="js/main.js">
</script><script defer src="js/app.js">
</script><script src="js/tilt.jquery.js">
</script>