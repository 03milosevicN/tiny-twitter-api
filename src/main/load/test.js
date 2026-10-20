import http from 'k6/http';
import { sleep, check } from 'k6';

// test config
export const options = {
    stages: [
        { duration: '1m', target: 20 }, // up to 20 users in 1min
        { duration: '3m', target: 20 }, // hold for 3min
        { duration: '1m', target: 0 },  // down to 0 users in 1min
    ],
}
// test config

// export const options = {
//     // num of virtual users
//     vus: 10,
//     duration: '30s',
//     thresholds: {
//         // 95% request completion under 500ms
//         http_req_duration: ['p(95)<500'],
//         // request failure rate
//         http_req_failed: ['rate<0.01']
//     }
// };


// // test
// export default function() {
//     const res = http.get('http://localhost:8080/api/feed');
//
//     check(res, {
//         'status is 200': (r) => r.status === 200,
//         'response time is acceptable': (r) => r.timings.duration < 500
//     });
//
//     // simulated user activity
//     sleep(1);
// }
// // test

// multiple endpoints test
export default function() {

    const routes = new Map([
        ['get-feed', `http://localhost:8080/api/feed`],
        ['create-post', `http://localhost:8080/api/posts`],
    ]);
    let postReq = {
      content: "POST via Grafana k6.",
      "createdAt": Date.now(),
    };

    const responses = http.batch([
        ['GET',  routes.get('get-feed')],
        ['POST', routes.get('create-post'), JSON.stringify(postReq)],
    ]);

    check(responses[0], { 'GET Loaded': (r) => r.status === 200 });
    check(responses[1], { 'POST Loaded': (r) => r.status === 200 });
}
// multiple endpoints test