let eventGuid = 0;
let todayStr = new Date().toISOString().replace(/T.*$/, ""); // YYYY-MM-DD of today

export const INITIAL_EVENTS = [{
  url: 'http://localhost:9090/scheduler/{companyCode}',
  method: 'GET',
  color: 'yellow',   // a non-ajax option
  textColor: 'black' // a non-ajax option
}];

export function createEventId() {
  return String(eventGuid++);
}
