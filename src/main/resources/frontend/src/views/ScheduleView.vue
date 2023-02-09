<template>
  <div>
    <!-- 대타등록  -->

    <h2 class="title">대타 요청</h2></br><h3><i class="fa-solid fa-house"></i> 지점명: 스타벅스 숙대점</h3>
    <hr class="line mb-5" />
    <div class="container">
      <div class="header">
           <div class="input-group">
          <form @submit.prevent="submitForm">
            
            <div class="input-group">
              
            <label class="input-group-text" for="inputGroupSelect02"
              >이름</label
            >
               <input type="text" class="form-control" aria-label="Username" aria-describedby="basic-addon1" v-model="requestName"></input>
            <label class="input-group-text" for="inputGroupSelect01"
              >날짜</label
            >
            <input
              type="date"
              class="form-select"
              id="inputGroupSelect01"
              v-model="startDate"
            />
      
            <label class="input-group-text" for="inputGroupSelect02"
              >타임</label
            >
            <select class="form-select" aria-label="Default select example" v-model="part">
  <option value="오픈">오픈</option>
  <option value="미들">미들</option>
  <option value="마감">마감</option>
</select>
       
  
             
            </div>
            <div id="requestbtn" class="d-flex flex-row-reverse gap-2 mt-4 " >
              <button type="submit" class="btn btn-warning mt-1">
                대타 요청하기
              </button>
            </div>
            <div>
            
            </div>
          </form>
        </div>
      </div>
    </div>

    <!-- 대타리스트  -->

    <h2 class="title" @click="getData">스케쥴링</h2>
    <hr class="line" />

    <div class="p-4 mt-5">
      <div class="row g-1">
        <table class="table">
          <thead>
            <tr>
              <th scope="col">Name</th>
              <th scope="col">Date</th>
              <th scope="col">Part</th>
              <th scope="col">Time</th>
              <th scope="col">Btn</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="user in users">
              <!-- <th scope="row">1</th> -->
              <th>{{ user.requestName }}</th>

              <td>{{ user.startDate }} </td> <td>{{ user.part }}</td>

              <td>{{ user.startTime }} ~ {{ user.endTime }} </td>
              <td>
                <button 
                  type="button"
                  v-on:click="alertOK"
                  class="btn btn-success">
                  수락하기</button>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>

    <hr class="underline" />
    <div class="demo-app">
      <div class="demo-app-main" @click="getFull">
        <FullCalendar class="demo-app-calendar" :options="calendarOptions">
          <template v-slot:eventContent="arg">
            <b>{{ arg.timeText }}</b>
            <i>{{ arg.event.title }}</i>
          </template>
        </FullCalendar>
      </div>
    </div>

    <!-- <template v-else> -->
    <div class="container">
      <p class="text">아직 등록된 지점이 없습니다.</p>
      <router-link to="/login"
        ><button type="button" class="btn btn-danger">
          로그인 하러가기
        </button></router-link
      >
      <router-link to="/finding"
        ><button type="button" class="btn btn-warning">
          우리 지점 찾으러가기
        </button></router-link
      >
    </div>
    <!-- </template> -->
  </div>
</template>

<script>
import axios from "axios";
import ScheduleList from "@/components/ScheduleList.vue";
import FullCalendar from "@fullcalendar/vue";
import dayGridPlugin from "@fullcalendar/daygrid";
import timeGridPlugin from "@fullcalendar/timegrid";
import interactionPlugin from "@fullcalendar/interaction";
import { INITIAL_EVENTS, createEventId } from "./event-utils";
export default {
  components: {
    FullCalendar, // make the <FullCalendar> tag available,
    ScheduleList,
  },

    data: function () {
      return {
        id:'',
        requestPid:'',
        users:[],
        requestName:'',
        startDate: '',
        startTime: '',
        endTime: '',
        part:'',
        calendarOptions: {
          plugins: [
            dayGridPlugin,
            timeGridPlugin,
            interactionPlugin, // needed for dateClick
          ],

        headerToolbar: {
          left: "prev,next today myCustomButton",
          center: "title",
          right: "dayGridMonth,timeGridWeek,timeGridDay",
        },
        initialView: "dayGridMonth",
        initialEvents: INITIAL_EVENTS, // alternatively, use the `events` setting to fetch from a feed
        editable: true,
        selectable: true,
        selectMirror: true,
        dayMaxEvents: true,
        weekends: true,
        select: this.handleDateSelect,
        eventClick: this.handleEventClick,
        eventsSet: this.handleEvents,
        events: [],
      },
    };
  },
  computed: {
    isUserLogin() {
      return this.$store.getters.isLogin;
    },
    
  },
       methods: {
          async submitForm() {
            axios
              .post("http://localhost:9090/scheduler/help/request/", {
                requestName:this.requestName,
                startDate: this.startDate,
                part: this.part,
                startTime: this.startTime,
                endTime: this.endTime,
                companyName:"스타벅스숙대점"
              })
              .then((res) => {
                console.log(res);
              })
              .catch((err) => {
                console.log(err);
              });
          },
          alertOK: function (event) {
            alert("대타 등록이 완료되었습니다.")},
          async getData() {
            var vm = this;
            axios
              .get("http://localhost:9090/scheduler/스타벅스숙대점/help/")
              .then(function (response) {
                console.log(response.data);
                vm.users = response.data;
                this.initForm();

              })
              .catch(function (error) {
                console.log(error);
              });
          },

    async getFull() {
      var cal = this;
      axios
        .get("http://localhost:9090/scheduler/스타벅스숙대점")
        .then(function (response) {
          console.log(response.data);
          cal.calendarOptions.events = response.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    handleWeekendsToggle() {
      this.calendarOptions.weekends = !this.calendarOptions.weekends // update a property
    },
    handleDateSelect(selectInfo) {
      let title = prompt('Please enter a new title for your event')
      let calendarApi = selectInfo.view.calendar
      calendarApi.unselect() // clear date selection
      if (title) {
        calendarApi.addEvent({
          id: createEventId(),
          title,
          start: selectInfo.startStr,
          end: selectInfo.endStr,
          allDay: selectInfo.allDay
        })
      }
    },
    handleEventClick(clickInfo) {
      if (confirm(`Are you sure you want to delete the event '${clickInfo.event.title}'`)) {
        clickInfo.event.remove()
      }
    },
    handleEvents(events) {
      this.currentEvents = events
    },
    initForm() {

    },
  }
}
</script>
<style scoped>
h3{
  font-size:16px;
    margin-left: 8%;
}

#requestbtn{
  margin-right:-16%;
  margin-bottom: 10%;
}
.input-group{
  margin-top: 1.5%;
  margin-left: 16%;

}
.title {
  font-weight: 600;
  font-size: 32px;
  margin-top: 48px;
  margin-left: 8%;
}

.line {
  width: 98%;
  margin-left: 1%;
}

.unedrline {
  width: 98%;
  margin-left: 1%;
  margin-top: 2%;

  margin-bottom: 10%;
}

h2 {
  margin: 0;
  font-size: 16px;
}
ul {
  margin: 0;
  padding: 0 0 0 1.5em;
}
li {
  margin: 1.5em 0;
  padding: 0;
}
b {
  /* used for event dates/times */
  margin-right: 3px;
}
.demo-app {
  display: flex;
  min-height: 100%;
  font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
  font-size: 14px;
}
.demo-app-sidebar {
  width: 300px;
  line-height: 1.5;
  background: #eaf9ff;
  border-right: 1px solid #d3e2e8;
}
.demo-app-sidebar-section {
  padding: 2em;
}
.demo-app-main {
  flex-grow: 1;
  padding: 3em;
}
.fc {
  /* the calendar root */
  max-width: 1100px;
  margin: 0 auto;
}

.table{
  width:80%;
  margin-left:12%;
  /* margin-top: -4%; */
  text-align: center;
}
</style>
