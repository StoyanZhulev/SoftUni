function orderTickets(ticketsArr, sortBy) {
    let tickets = [];
    class Ticket{
        constructor(destination, price, status){
            this.destination = destination;
            this.price = Number(price);
            this.status = status;
        }
    }

    for (let t of ticketsArr) {
        let ticketArgs = t.split('|').filter(e => e!=='');
        let ticket = new Ticket(ticketArgs[0], ticketArgs[1], ticketArgs[2]);
        tickets.push(ticket);
    }

    return tickets.sort((a, b) => sortBy === 'price' ? a[sortBy] - b[sortBy] : a[sortBy].localeCompare(b[sortBy]));
}