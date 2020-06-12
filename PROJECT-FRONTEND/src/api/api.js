import axios from "axios";

const baseUrl = 'http://localhost:8080/api/';

let instance = axios.create({
    baseURL: baseUrl,
});

instance.interceptors.request.use(
    config => {
        config.headers.Authorization = "Bearer_" + localStorage.getItem("hv-token")
        return config
    }
);

export const vacationApi = {
    getPublicVacations() {
        return instance.get('public-vacations/')
    },
    getVacations() {
        return instance.get('vacations/')
    },
    createVacation(data){
        debugger
        return instance.post('vacations/',
            {title:data.title,
                description: data.description,
                country: data.country,
                city: data.city,
                startDate: data.startDate,
                endDate: data.endDate
            })
    },
    getVacation(id){
        return instance.get('vacations/'+id);
    },
    deleteVacation(id) {
        return instance.delete('vacations/'+id);
    }
};

export const userApi = {
    login(username, password) {
        return instance.post('auth/login/',
            {username: username, password: password})
    },
    getUser() {
        return instance.get('auth/check/')
    },
    register(username, password) {
        return instance.post("/user/",
            {
                username: username,
                password: password
            })
    }
};


export const authApi = {

};

