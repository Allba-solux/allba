<template>
  <div>
    <!-- <template v-if="isUserLogin" > -->
   

    <h2 class="title">대타 등록하기</h2>
    <hr class="line" />

    <div class="container">
      <div class="header">
        <div class="input-group mb-3">
          <form @submit.prevent="submitForm">
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
              id="inputGroupSelect02"
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
            <div class="d-flex flex-row-reverse gap-2 mt-4">
              <button type="submit" class="btn btn-warning">
                대타 요청하기
              </button>
            </div>
            <div>
              <h3 class="join_title"><label for="userName">이름</label></h3>
              <span class="box int_name">
                <input
                  type="text"
                  id="name"
                  class="int"
                  maxlength="20"
                  v-bind="userName"
                />
              </span>
            </div>
          </form>
        </div>
      </div>

      <!-- <div class="form-floating">
                <textarea class="form-control mt-3" placeholder="Leave a comment here" id="floatingTextarea2"
                    style="height: 100px"></textarea>
                <label for="floatingTextarea2">내용</label>
            </div> -->

      <!-- <div class="d-flex flex-row-reverse gap-2 mt-4">
            <router-link to="/schedule"><button type="button" class="btn btn-outline-dark">
                목록
            </button></router-link>
            <button type="submit" class="btn btn-outline-success">등록</button>
        </div> 
        </div>-->
    </div>
     <ScheduleList></ScheduleList>
    <hr class="underline" />
    <div class="demo-app">
      <!-- <div class="demo-app-sidebar">
        <div class="demo-app-sidebar-section">
          <h2>Instructions</h2>
          <ul>
            <li>Select dates and you will be prompted to create a new event</li>
            <li>Drag, drop, and resize events</li>
            <li>Click an event to delete it</li>
          </ul>
        </div>
        <div class="demo-app-sidebar-section">
          <label>
            <input
              type="checkbox"
              :checked="calendarOptions.weekends"
              @change="handleWeekendsToggle"
            />
            toggle weekends
          </label>
        </div>
        <div class="demo-app-sidebar-section">
          <h2>All Events ({{ currentEvents.length }})</h2>
          <ul>
            <li v-for="event in currentEvents" :key="event.id">
              <b>{{ event.title }}</b>
              <i>{{ event.starttime }}</i>
            </li>
          </ul>
        </div>
      </div> -->
      <div class="demo-app-main">
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
      startDate: "",
      startTime: "",
      endDate: "",
      endTime: "",
      userName: "",
      calendarOptions: {
        plugins: [
          dayGridPlugin,
          timeGridPlugin,
          interactionPlugin, // needed for dateClick
        ],
        customButtons: {
          myCustomButton: {
            text: "custom!",
            click: function () {
              alert("clicked the custom button!");
            },
          },
        },
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
      },
      currentEvents: [],
    };
  },
  computed: {
    isUserLogin() {
      return this.$store.getters.isLogin;
    },
  },
  methods: {
    makeevent() {
      calendarApi.addEvent({
        id: createEventId(),
        title: $route.params.id,
        start: this.startday,
        end: this.endday,
        allDay: selectInfo.allday,
      });
    },
    async submitForm() {
      axios
        .post("http://localhost:9090/scheduler/${companyCode}/new", {
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
    handleWeekendsToggle() {
      this.calendarOptions.weekends = !this.calendarOptions.weekends; // update a property
    },
    // handleDateSelect(selectInfo) {
    //   let title = prompt('Please enter a new title for your event')
    //   let calendarApi = selectInfo.view.calendar
    //   calendarApi.unselect() // clear date selection
    //   if (title) {
    //     calendarApi.addEvent({
    //       id: createEventId(),
    //       title,
    //       start:selectInfo.startStr,
    //       end:selectInfo.endStr,
    //       allDay: selectInfo.allDay
    //     })
    //   }
    // },
    handleEventClick(clickInfo) {
      if (
        confirm(
          `Are you sure you want to delete the event '${clickInfo.event.title}'`
        )
      ) {
        clickInfo.event.remove();
      }
    },
    handleEvents(events) {
      this.currentEvents = events;
    },
  },
};
</script>
<style scoped>
.title {
  font-weight: 600;
  font-size: 32px;
  margin-top: 48px;
  margin-left: 8%;
}

.line {
  width: 90%;
  margin-left: 5%;
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
