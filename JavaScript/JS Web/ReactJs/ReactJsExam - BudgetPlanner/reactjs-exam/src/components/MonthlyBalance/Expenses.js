import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import toastr from 'toastr';




function getMonthNum(month){
    switch(month){
        case "January":
             return '1';
        case 'February':
             return '2';
        case 'March':
             return '3';
        case 'April': 
            return '4';
        case 'May':
            return '5';
        case 'June':
            return '6';
        case 'July':
            return '7';
        case 'August': 
            return '8';
        case 'September':
            return '9';
        case 'October':
            return '10';
        case 'November': 
            return '11';
        case '12':
            return '12';
        default:
            return month;
    }
  }

 
export default function Expenses({id, remove, name, category, date, cost}) {
    return (
    <tr>
        <td>{name}</td>
        <td>{category}</td>
        <td>{cost}</td>
        <td>{date}</td>
        <td>

  <a href="javascript:void(0)" onClick={remove} className="btn btn-secondary">Delete</a>
</td>
</tr>


    );
}





