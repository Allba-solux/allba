<template>
  <div id="app">
    <ToolBar></ToolBar>
      <transition name="page">
      <router-view></router-view>
      </transition>
  </div>
  
</template>

<script>
import ToolBar from './components/ToolBar.vue';

export default {
  components:{
    ToolBar,
  }
}
</script>


<style>

* {
  margin: 0;
  padding: 0;
}

html,
body,
div,
span,
applet,
object,
iframe,
h1,
h2,
h3,
h4,
h5,
h6,
p,
blockquote,
pre,
a,
abbr,
acronym,
address,
big,
cite,
code,
del,
dfn,
em,
font,
img,
ins,
kbd,
q,
s,
samp,
small,
strike,
strong,
sub,
sup,
tt,
var,
b,
u,
i,
center,
dl,
dt,
dd,
ol,
ul,
li,
fieldset,
form,
label,
legend,
table,
tbody,
tfoot,
thead,
tr,
th,
td {
  margin: 0;
  padding: 0;
}

h1,
h2,
h3,
h4,
h5,
h6 {
  font-weight: 700;
  font-size: inherit;
}

a {
  color: inherit;
  text-decoration: inherit;
}

img {
  vertical-align: middle;
}

a img {
  border: none;
}

li {
  list-style: none;
}

address,
em,
i {
  font-style: normal;
}

body {
  font-family: 'NanumSquare', sans-serif !important;
  font-size: 14px;
  color: #4e4e4e;
  line-height: 1.4;
}

.wrap {
  width: 100%;
  min-width: 1100px;
}
</style>
