document.write("<script src=\"https://unpkg.com/axios/dist/axios.min.js\"></script>");

function register_func() {
    const name = document.getElementById("userName").value;
    const password = document.getElementById("password").value;
    const teacher_url = 'http://localhost:8080/proxy/teacher-service/Teacher/register';
    const student_url = 'http://localhost:8080/proxy/student-service/Student/register';
    if (document.getElementById("teacher").checked) {
        axios({
            method: 'post',
            url: teacher_url,
            data: {
                "name": name,
                "password": password
            },
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json;charset=utf-8"
            }
        })
            .then(function (response) {
                alert("Teacher register successfully")
            })
            .catch(function (error) {
                alert("Teacher fail to register")
            });
    }
    if (document.getElementById("student").checked) {
        axios({
            method: 'post',
            url: student_url,
            data: {
                "name": name,
                "password": password
            },
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json;charset=utf-8"
            }
        })
            .then(function (response) {
                alert("Student register successfully");
            })
            .catch(function (error) {
                alert("Student fail to register");
            });
    }
}

function login_func() {
    const name = document.getElementById("userName").value;
    const password = document.getElementById("password").value;
    const teacher_url = 'http://localhost:8080/proxy/teacher-service/Teacher/login';
    const student_url = 'http://localhost:8080/proxy/student-service/Student/login';
    // alert("name = " + name + ", password = " + password);
    if (document.getElementById("teacher").checked) {
        axios({
            method: 'post',
            url: teacher_url,
            data: {
                "name": name,
                "password": password
            },
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json;charset=utf-8"
            }
        })
            .then(function (response) {
                // alert("Teacher register successfully");
                if (response.data.code === 0) {
                    window.location = "homework-teacher.html";
                }

            })
            .catch(function (error) {
                alert("Teacher fail to register");
            });
    }
    if (document.getElementById("student").checked) {
        axios({
            method: 'post',
            url: student_url,
            data: {
                "name": name,
                "password": password
            },
            headers: {
                "Access-Control-Allow-Origin": "*",
                "Content-Type": "application/json;charset=utf-8"
            }
        })
            .then(function (response) {
                // alert("Student register successfully");
                window.location = "homework-student.html";
            })
            .catch(function (error) {
                alert("Student fail to register");
            });
    }

}