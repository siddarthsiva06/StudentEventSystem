const STUDENT_BASE_URL = "http://localhost:8081/api/students";
const EVENT_BASE_URL = "http://localhost:8082/api/events";

// Register
export const registerStudent = async (data: {
  rollNumber: string;
  name: string;
  email: string;
  password: string;
}) => {
  const res = await fetch(`${STUDENT_BASE_URL}/register`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });
  if (!res.ok) throw new Error("Registration failed");
  return res.json();
};

// Login — returns { token }
export const loginStudent = async (data: {
  email: string;
  password: string;
}) => {
  const res = await fetch(`${STUDENT_BASE_URL}/login`, {
    method: "POST",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(data),
  });

  if (!res.ok) throw new Error("Login failed");

  return res.json();
};

// Get student by roll number
export const getStudentByRollNumber = async (rollNumber: string) => {
  const res = await fetch(`${STUDENT_BASE_URL}/roll/${rollNumber}`);
  if (!res.ok) throw new Error("Failed to fetch student");
  return res.json();
};

// Get events for a specific student by roll number
export const getEventsByRollNumber = async (
  rollNumber: string,
  token: string
) => {
  const res = await fetch(`${EVENT_BASE_URL}/student/${rollNumber}`, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });

  if (!res.ok) throw new Error("Failed to fetch events");

  return res.json();
};

// Get all events
export const getAllEvents = async (token: string) => {
  const res = await fetch(`${EVENT_BASE_URL}/all`, {
    headers: {
      Authorization: `Bearer ${token}`,
    },
  });

  if (!res.ok) throw new Error("Failed to fetch events");

  return res.json();
};

// Add an event (requires JWT token)
export const addEvent = async (
  event: {
    rollNumber: string;
    studentName: string;
    eventName: string;
    eventLocation: string;
    eventDate: string;
    eventDescription: string;
  },
  token: string
) => {
  const res = await fetch(`${EVENT_BASE_URL}/add`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${token}`,
    },
    body: JSON.stringify(event),
  });
  if (!res.ok) throw new Error("Failed to add event");
  return res.json();
};
