import React, { Component } from 'react';
import { getYearlyBalance, deleteHotel } from '../../api/remote';
import MonthsList from './MonthsList';
import { Link } from 'react-router-dom';

export default class YearlyBalance extends Component {
    constructor(props) {
        super(props);

        this.state = {
            year: 2017,
            months: {}
        };

    }

    componentDidMount() {
        this.getData();
    }


    async getData(year = Number(this.props.match.params.year)) {
        const data = await getYearlyBalance(year);
        this.setState({ months: data, year });
    }



    render() {
        return (
<div>
  <div className="row space-top">
    <div className="col-md-12">
      <h1>Yearly Balance</h1>
    </div>
  </div>
  <MonthsList months={this.state.months} year={this.state.year}/> 
</div>

        );
    }
}