DO
$$
DECLARE
    i INT;
    first_names TEXT[] := ARRAY['John', 'Jane', 'Alex', 'Chris', 'Pat', 'Taylor', 'Jordan', 'Morgan', 'Casey', 'Drew'];
    last_names TEXT[] := ARRAY['Smith', 'Johnson', 'Williams', 'Jones', 'Brown', 'Davis', 'Miller', 'Wilson', 'Moore', 'Taylor'];
    job_titles TEXT[] := ARRAY['Manager', 'Developer', 'Analyst', 'Engineer', 'Specialist', 'Coordinator', 'Consultant', 'Administrator', 'Director', 'Executive'];
    departments TEXT[] := ARRAY['HR', 'Finance', 'Admin', 'Sales', 'IT', 'Marketing'];
    gender_options TEXT[] := ARRAY['Male', 'Female'];
    start_date DATE := '2023-01-01';
    end_date DATE := '2024-05-17';
BEGIN
    FOR i IN 1..100 LOOP
        INSERT INTO employee (first_name, last_name, email, phone_number, hire_date, job_title, salary, gender, department)
        VALUES (
            first_names[(i % array_length(first_names, 1)) + 1],
            last_names[(i % array_length(last_names, 1)) + 1],
            lower(first_names[(i % array_length(first_names, 1)) + 1] || '.' || last_names[(i % array_length(last_names, 1)) + 1] || i || '@company.com'),
            '555-010' || lpad((i % 10)::text, 2, '0'),
            start_date + (random() * (end_date - start_date))::int,
            job_titles[(i % array_length(job_titles, 1)) + 1],
            round((random() * 50000 + 50000)::numeric, 2),
            gender_options[(i % array_length(gender_options, 1)) + 1],
            departments[(i % array_length(departments, 1)) + 1]
        );
    END LOOP;
END
$$;
