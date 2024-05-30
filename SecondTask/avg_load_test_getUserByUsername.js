import http from 'k6/http';
import { sleep, check } from 'k6';

export const options = {
    stages: [
        { duration: '2m', target: 5 },
        { duration: '30m', target: 5 },
        { duration: '2m', target: 0 },
    ],
};

const baseUrl = 'http://localhost:8080/api/v3';

export default () => {
    const res = http.get(`${baseUrl}/user/theUser`);
    check(res, {
        'is status 200': (r) => r.status === 200,
    });
    sleep(1);
};