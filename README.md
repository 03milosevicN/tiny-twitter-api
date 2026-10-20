# RESULTS

## 20.08.26:10:25
```
TOTAL RESULTS 
    checks_total.......: 3429990 11434.690039/s
    checks_succeeded...: 50.00%  1714995 out of 3429990
    checks_failed......: 50.00%  1714995 out of 3429990

    ✓ GET Loaded
    ✗ POST Loaded
      ↳  0% — ✓ 0 / ✗ 1714995

    HTTP
    http_req_duration..............: avg=1.58ms min=121µs    med=696µs  max=103.77ms p(90)=3.69ms p(95)=4.29ms
      { expected_response:true }...: avg=2.74ms min=206µs    med=2.72ms max=103.77ms p(90)=4.27ms p(95)=4.85ms
    http_req_failed................: 50.00%  1714995 out of 3429990
    http_reqs......................: 3429990 11434.690039/s

    EXECUTION
    iteration_duration.............: avg=2.81ms min=228.79µs med=2.79ms max=105.48ms p(90)=4.35ms p(95)=4.93ms
    iterations.....................: 1714995 5717.34502/s
    vus............................: 1       min=1                  max=20
    vus_max........................: 20      min=20                 max=20

    NETWORK
    data_received..................: 9.9 GB  33 MB/s
    data_sent......................: 408 MB  1.4 MB/s
```