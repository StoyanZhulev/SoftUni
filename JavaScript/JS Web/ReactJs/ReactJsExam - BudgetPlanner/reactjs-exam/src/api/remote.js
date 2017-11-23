const host = 'http://localhost:5000/';

async function register(name, email, password) {
    const res = await fetch(host + 'auth/signup', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name,
            email,
            password,
        })
    });
    return await res.json();
}

async function login(email, password) {
    const res = await fetch(host + 'auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            email,
            password, 
        })
    });
    return await res.json();
}

async function createExpense(year, month, date, name, category, amount) {
    const res = await fetch(host + `plan/${(year)}/${Number(month)}/expense`, {
        method: 'POST',
        headers: {
            'Authorization': 'bearer ' + localStorage.getItem('authToken'),
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            date, name, category, amount
        })
    });
    return await res.json();
}


async function getYearlyBalance(year) {
    console.log(year);
    
    const res = await fetch(host + 'plan/' + year, {
        method: 'GET',
        headers: {
            'Authorization': 'bearer ' + localStorage.getItem('authToken'),
            'Content-Type': 'application/json'
        },
    });
    return await res.json();
}

async function getMonthlyBalance(year, month) {
 console.log(year);
console.log(month);
   
    const res = await fetch(host + `plan/${(year)}/${Number(month)}`, {
        method: 'GET',
        headers: {
            'Authorization': 'bearer ' + localStorage.getItem('authToken'),
            'Content-Type': 'application/json'
        },
    });
    console.log(res);
    
    return await res.json();
}

async function getExpenseCreate(year, month, expense) {
    
     const res = await fetch(host + `plan/${(year)}/${Number(month)}/expense`, {
         method: 'POST',
         headers: {
             'Authorization': 'bearer ' + localStorage.getItem('authToken'),
             'Content-Type': 'application/json'
         },
         body: JSON.stringify(expense)
     });

     console.log(' Sect\n' );
     console.log(expense);
     
     

     return await res.json();
 }

async function updateMonthlyBalance(year, month, income, budget) {
    
    const res = await fetch(host + `plan/${Number(year)}/${Number(month)}`, {
        method: 'POST',
        headers: {
            'Authorization': 'bearer ' + localStorage.getItem('authToken'),
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            income: Number(income),
            budget: Number(budget)
        })

    });
    return await res.json();
}




async function deleteExpense(id) {
    const res = await fetch(host + `plan/expense/` + id, {
        method: 'DELETE',
        headers: {
            'Authorization': 'bearer ' + localStorage.getItem('authToken'),            
        }
    });
    return await res.json();
}

export { register, login, createExpense, getYearlyBalance, getMonthlyBalance, updateMonthlyBalance, getExpenseCreate, deleteExpense };