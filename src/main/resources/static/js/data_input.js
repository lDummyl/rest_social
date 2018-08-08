// var messageApi = Vue.resource('/pump-selection');
//
// Vue.component('message-form', {
//     props:['messages'],
//     data: function(){
//         return{
//             text: 'test'
//         }
//     },
//     template:
//     '<div>' +
//         // '<input type="text" placeholder = "Type your new message" v-model="text"/>' +
//     '<a href="#" class="button7" @click = "save">Рассчитать</a>'+
//     '<div/>',
//     methods: {
//         save: function(){
//
//             var unit_type_selected = document.getElementById("unit_type").value.valueOf();
//             var unit_flow = document.getElementById("flow").value.valueOf();
//             var unit_preslose = document.getElementById("preslose").value.valueOf();
//
//             var result = unit_type_selected + unit_flow + unit_preslose;
//
//             var message = {text : result};
//
//             messageApi.save({},message);
//
//             draw();
//
//         }
//     }
// });
//
// // Vue.js framework main object
// var data_input = new Vue({
//     el: '#data_input',
//     // data: {
//     //     message: 'Hello!'
//     // }
//     template:'<message-form :messages="messages" />',
//     data: {
//         messages: []
//     }
// })
//
