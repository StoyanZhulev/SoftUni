import React from 'react';
import { Link } from 'react-router-dom';


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
      break;
  }
}
export default function Month({ month, budget, balance, year }) {
    return (
        <div className="row space-top col-md-12">
        <div className="col-md-3">
          <div className="card text-white bg-secondary">
            <div className="card-body">
              <blockquote className="card-blockquote">
                <h2>{month}</h2>
                <h4>Year {year}</h4>
                <label htmlFor="budget">Budget:</label>
                <input className="col-md-9" name="budget" value={budget} disabled />
                <label htmlFor="balance">Balance:</label>
                <input className="col-md-9" name="balance" value={balance} disabled />
                <div className="space-top">
                <Link  to={{ pathname: `/plan/${year}/${getMonthNum(month)}`}}>Details</Link>
                 {/* {`<a href="/plan/${year}/${month}" className="btn btn-secondary">Details</a>`} */}
                </div>
              </blockquote>
            </div>
          </div>
        </div>
        </div>
    );
}