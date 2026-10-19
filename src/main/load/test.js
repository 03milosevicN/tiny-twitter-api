import http from 'k6/http';
import { sleep, check } from 'k6';

export const options = {
    // num of virtual users
    vus: 10,
    duration: '30s',
    thresholds: {
        // 95% request completion under 500ms
        http_req_duration: ['p(95)<500'],
        // request failure rate
        http_req_failed: ['rate<0.01']
    }
};


// test
export default function() {
    const res = http.get('');

    check(res, {
        'status is 200': (r) => r.status === 200,
        'response time is acceptable': (r) => r.timings.duration < 500
    });

    // simulated user activity
    sleep(1);
}
// test