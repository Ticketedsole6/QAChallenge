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

  const payload = JSON.stringify({
    id: 10,
    name: "doggie",
    category: {
      id: 1,
      name: "Dogs"
    },
    photoUrls: [
      "string"
    ],
    tags: [
      {
        id: 0,
        name: "string"
      }
    ],
    status: "available"
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