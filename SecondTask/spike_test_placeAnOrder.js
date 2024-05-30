import http from 'k6/http';
import { sleep, check } from 'k6';

export const options = {
    stages: [
        { duration: '2m', target: 100 },
        { duration: '1m', target: 0 },
    ],
};

const baseUrl = 'http://localhost:8080/api/v3';

export default () => {

    const payload = JSON.stringify({
        id: 10,
        petId: 198772,
        quantity: 7,
        shipDate: "2024-05-30T13:26:52.858Z",
        status: "approved",
        complete: true
    });

    const params = {
        headers: {
            'Content-Type': 'application/json',
        },
    };

    const res = http.post(`${baseUrl}/pet`, payload, params);

    check(res, {
        'is status 200': (r) => r.status === 200,
    });
    sleep(1);
};