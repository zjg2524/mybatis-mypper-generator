import React, { Component } from 'react';
import { ReactiveBase, DataSearch, NumberBox, DateRange, RangeSlider, ResultCard,MultiList,TagCloud} from '@appbaseio/reactivesearch';

import './App.css';

export default () => (
    <div className="container">
        <ReactiveBase
            app="testairbnb"
            url="http://127.0.0.1:9200"
            type="doc"
            theme={{
                primaryColor: '#FF3A4E',
            }}
        >
            <nav className="nav">
                <div className="title">MyAirbnb</div>
                <DataSearch
                    componentId="SearchSensor"
                    dataField="name"
                    autosuggest={false}
                    placeholder="Search by house names"
                    iconPosition="left"
                    className="search"
                    highlight={true}
                />
            </nav>
            <div className="left-col">
                <DateRange
                    dataField="date_from"
                    componentId="DateRangeSensor"
                    title="When"
                    numberOfMonths={2}
                    queryFormat="basic_date"
                    initialMonth={new Date('04-01-2017')}
                />

                <NumberBox
                    componentId="GuestSensor"
                    dataField="accommodates"
                    title="Guests"
                    defaultSelected={2}
                    labelPosition="right"
                    data={{
                        start: 1,
                        end: 16,
                    }}
                />

                <RangeSlider
                    componentId="PriceSensor"
                    dataField="price"
                    title="Price Range"
                    range={{
                        start: 10,
                        end: 250,
                    }}
                    rangeLabels={{
                        start: '$10',
                        end: '$250',
                    }}
                    defaultSelected={{
                        start: 10,
                        end: 50,
                    }}
                    stepValue={10}
                    interval={20}
                    react={{
                        and: ['DateRangeSensor'],
                    }}
                />

                <MultiList
                    componentId="RoomTypeSensor"
                    dataField="room_type.keyword"
                    title="RoomType"
                    size={100}
                    react={{
                        and: ['DateRangeSensor','PriceSensor','GuestSensor'],
                    }}
                />

                <TagCloud
                    componentId="BedTypeTagCloud"
                    dataField="bed_type.keyword"
                />

            </div>

                <ResultCard
                className="right-col"
                componentId="SearchResult"
                dataField="name"
                size={12}
                onData={data => ({
                    image: data.image,
                    title: data.name,
                    description: (
                        <div>
                            <div className="price">${data.price}</div>
                            <p className="info">{data.room_type} · {data.accommodates} guests</p>
                        </div>
                    ),
                    url: data.listing_url,
                })}
                pagination
                react={{
                    and: ['SearchSensor', 'GuestSensor', 'PriceSensor', 'DateRangeSensor', 'RoomTypeSensor','search'],
                }}
                innerClass={{
                    resultStats: 'result-stats',
                    list: 'list',
                    listItem: 'list-item',
                    image: 'image',
                }}
            />
        </ReactiveBase>
    </div>
);
