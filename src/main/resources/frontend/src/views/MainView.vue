<template >
  <div>
    <img src="@/assets/main2.jpg" class="img-fluid"></img>
           <footer>
           <h2 class="footerLogo">Allba<i class="fa-solid fa-clock-rotate-left"></i></h2>
           <ul>
               <li>FORNT-END 김지은 유영서 | BACK-END 이가은 장혜지 한수정 </li>
               <li>soluxallba@gmail.com</li>
               <li><span class="copyright">COPYRIGHT 2023</span></li>  
           </ul>
       </footer>
   
    
  </div>
</template>
<script>
export default {
  
}
</script>
<style>
footer {padding-top: 10px;padding-bottom: 10px; text-align: center;}
footer .footerLogo {font-size: 30px;; font-weight: 900; letter-spacing: -4px; color: #39312b; margin: 40px 0 20px;}
footer ul li{font-size: 17px; line-height: 1.4;}
footer ul li .copyright {font-size: 15px; font-weight: 100; color:#888; display: block; margin-top:20px; margin-bottom: 30px; }
footer .box {padding: 150px 0; background: no-repeat center/cover; margin-top: 80px;}
footer .box h2 {color: #fff; font-size: 22px; font-weight: normal; animation-name: slid-up; animation-duration: 1s;}
</style>