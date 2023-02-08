<template>
  <div>
    <!-- 대타등록  -->

    <h2 class="title">대타 등록하기</h2>
    <hr class="line mb-5" />
    <div class="container">
      <div class="header">
        <div class="input-group">
          <form @submit.prevent="submitForm">
            <div class="input-group">
               <input type="text" class="form-control" placeholder="이름입력" aria-label="Username" aria-describedby="basic-addon1" v-model="userName"></input>
            <label class="input-group-text" for="inputGroupSelect01"
              >시작일</label
            >
            <input
              type="date"
              class="form-select"
              id="inputGroupSelect01"
              v-model="startDate"
            />
      
            <label class="input-group-text" for="inputGroupSelect02"
              >시작시간</label
            >
            <input
              type="time"
              class="form-select"
              id="inputGtroupSelec02"
              v-model="startTime"
            />
            <label class="input-group-text" for="inputGroupSelect01"
              >종료일</label
            >
            <input
              type="date"
              class="form-select"
              id="inputGroupSelect01"
              v-model="endDate"
            />
            <label class="input-group-text" for="inputGroupSelect03"
              >종료 시간</label
            >
            <input
              type="time"
              class="form-select"
              id="inputGroupSelect03"
              v-model="endTime"
            />
             
            </div>
            <div class="d-flex flex-row-reverse gap-2 mt-4">
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
              <th scope="col">name</th>
              <th scope="col">start</th>
              <th scope="col">end</th>
              <th scope="col">btn</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="user in users">
              <!-- <th scope="row">1</th> -->
              <td>{{ user.userName }}</td>
              <td>{{ user.startDate }} | {{ user.startTime }}</td>

              <td>{{ user.endDate }} | {{ user.endTime }}</td>
              <td></td>
              <td>
                <button type="button" class="btn btn-success">수락하기</button>
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
      users: [],
      start: '',
      end: '',
      title: '',
      startDate: '',
      startTime: '',
      endDate: '',
      endTime: '',
      userName: '',
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
        .post("http://localhost:9090/scheduler/{companyCode}/help", {
          startDate: this.startDate,
          startTime: this.startTime,
          endDate: this.endDate,
          endTime: this.endTime,
          userName: this.userName,
        })
        .then((res) => {
          console.log(res);
        })
        .catch((err) => {
          console.log(err);
        });
    },
    async getData() {
      var vm = this;
      axios
        .get("http://localhost:9090/scheduler/{companyCode}/data")
        .then(function (response) {
          console.log(response.data);
          vm.users = response.data;
        })
        .catch(function (error) {
          console.log(error);
        });
    },
    async getFull() {
      var cal = this;
      axios
        .get("http://localhost:9090/scheduler/{companyCode}")
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
    EVENT_LIST() {
      axios
        .get("http://localhost:9090/scheduler/{companyCode}")
        .then(function (response) {
          console.log(response.data);
          this.users = response.data;
          for (var i = 0; i < users.length; i++) {
            INITIAL_EVENTS[i].title.push(user.title),
              INITIAL_EVENTS[i].start.push(user.start),
              INITIAL_EVENTS[i].end.push(user.end)
          }
          return INITIAL_EVENTS;
        })
        .catch(function (error) {
          console.log(error);
        });
    }
  }
}
</script>
<style scoped>
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
</style>
